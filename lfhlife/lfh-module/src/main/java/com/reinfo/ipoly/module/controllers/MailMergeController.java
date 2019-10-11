/**
 * 
 */
package com.reinfo.ipoly.module.controllers;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.PseudoColumnUsage;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reinfo.ipoly.module.models.*;
import com.reinfo.ipoly.module.report.utils.BuildPpsLt;
import com.reinfo.ipoly.module.report.utils.BuildPpsMed;
import com.reinfo.ipoly.module.report.utils.BuildPpsMedGold;
import com.reinfo.ipoly.module.report.utils.BuildPpsWlp;
import com.reinfo.ipoly.module.services.IlfQuotPlanService;
import com.reinfo.ipoly.module.services.ProdCovTabService;
import com.reinfo.ipoly.module.services.ProdPremRateService;
import com.reinfo.ipoly.module.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.services.IlfQuotService;
import com.reinfo.ipoly.module.utils.MailMerge;

import net.sf.jasperreports.data.cache.PopulatedSnapshotCacheHandler;

/**
 * @author Jms
 *
 */
@Controller
@RequestMapping(value = "mailMerge")
public class MailMergeController extends BaseWebController {

	@Autowired
	IlfQuotService quotService;
	
	@Autowired
	IlfQuotPlanService quotPlanService;

	@Autowired
	ProdCovTabService covTabService;
	
	@Autowired
	ProdPremRateService premRateService;

    @ResponseBody
    @RequestMapping(value = "proposalDownload.json")
    public void pdfDownload(@RequestBody  IlfQuot quotation, final HttpServletResponse response, HttpSession session) throws Exception {    	
    	
    	boolean online = false;
    	
    	if(quotation==null || StringUtils.isBlank(quotation.getQuotNo())){
    		return;
    	}
    	
    	IlfQuot quot = quotService.getOneBy("quot_no", quotation.getQuotNo());
    	IlfQuotPlan plan = new IlfQuotPlan();
		plan.setQuplanNo(quotation.getQuotNo());
		//List<IlfQuotPlan> planList = quotPlanService.getList(plan);//計劃詳情列表
		List<QuotPlanDetail> planList = quotPlanService.getQuotPlanDetailList(plan);//計劃詳情列表
		
    	//String covcode = (String)Constants.covTab_Map.get(quot.getQuotPlan());//基本計劃的編號
    	String fileName = quot.getQuotNo()+".pdf";


    	//4.pps
    	Pps pps = buildPpsData(quot, planList);

    	
    	//5.ppsrecords
    	Ppsrecords ppsrecords = new Ppsrecords();
    	ppsrecords.setPps(pps);
    	
    	//6.data
    	Data data = new Data();
    	data.setPpsrecords(ppsrecords);
    	
    	//7.product
    	Product product = new Product();
    	product.setData(data);
    	//product.setMainDocumentPath( "pps"+quot.getQuotPlan().toLowerCase()+"_template.docx");//wlp > ppswlp_template.docx 基本保险模板
		product.setMainDocumentPath(getTempName(quot.getQuotPlan().toLowerCase()));// 基本保险模板
    	//Rider template
    	List<String> riderTemplate = new ArrayList<>();
    	for(Rider rider : pps.getRiders()){
    		if(rider.getRiderTemplate()!=null){
    			riderTemplate.add(rider.getRiderTemplate());
    		}
    	}
    	product.setDocumentPathList(riderTemplate);//附加保险模板
    	
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonString = mapper.writeValueAsString(product);
    	
    	MailMerge mm = new MailMerge();
    	byte[] fileBody = mm.generateReport(jsonString);
    	
    	if (fileBody == null) {
            return;
        }

        /**
         * 3.前端下载或预览
         */
    	List list = new ArrayList<String>();
        OutputStream outputStream = null;
        try {
            if (list != null) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
                response.reset();
                if (online) {
                    String[] names = fileName.split("\\.");
                    response.setContentType(names[names.length - 1]);
                    response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
                } else {
                    response.addHeader("Content-Length", "" + fileBody.length);
                    response.setContentType("application/octet-stream;charset=UTF-8");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                }
                outputStream = new BufferedOutputStream(response.getOutputStream());
                outputStream.write(fileBody);
            }
        } finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

	private Pps buildPpsData(IlfQuot quot, List<QuotPlanDetail> planList){
		Pps pps = null;
		String planCode = quot.getQuotPlan().toLowerCase();
		Criteria c = new Criteria();
		c.addWhere(ProdCovTab.DBStrCovCode, quot.getQuotYears());
		ProdCovTab prod = covTabService.getOneBy(c);
		switch (planCode) {
		case "wlp":
			pps = new BuildPpsWlp(quot, planList).buildPpsData();
			break;
		case "lt":
			pps = new BuildPpsLt(quot, planList, prod).buildPpsData();
			break;
		case "lts":
			pps = new BuildPpsLt(quot, planList, prod).buildPpsData();
			break;
		case "mth":
			pps = new BuildPpsLt(quot, planList, prod).buildPpsMTHData();
			break;
	    case "m001":
			case "m002":
			    case "m003":
				pps = new BuildPpsMed(quot, planList).buildPpsData();
				break;
	    case "m004":
			case "m005":
			   case "m006":
				pps = new BuildPpsMedGold(quot, planList).buildPpsData();
				break;
		default:
			break;
		}
		return pps;
	}
	public String getTempName(String QuotPlan){
		switch (QuotPlan) {

			case "m001":
			case "m002":
			case "m003":
				return "ppsmed_template.docx";
			case "m004":
			case "m005":
			case "m006":
				return "ppsmedgold_template.docx";
			case "lts":
				return "ppsltsp_template.docx";
			case "mth":
			case "mtj":
			case "mtl":
				return "ppsmort_template.docx";
			case "msd":
			case "msf":
			case "msh":
			case "msj":
			case "msl":
				return "ppsmortsp_template.docx";
			default:
				return "pps" + QuotPlan + "_template.docx";
		}
 	}
}
