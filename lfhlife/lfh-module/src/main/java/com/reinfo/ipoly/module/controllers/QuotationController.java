package com.reinfo.ipoly.module.controllers;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinfo.ipoly.common.config.SessionManager;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.models.Code;
import com.reinfo.ipoly.module.models.IlfQuot;
import com.reinfo.ipoly.module.models.IlfQuotPlan;
import com.reinfo.ipoly.module.models.LoginProfile;
import com.reinfo.ipoly.module.models.QuationProd;
import com.reinfo.ipoly.module.services.IlfQuotPlanService;
import com.reinfo.ipoly.module.services.IlfQuotService;

import groovy.transform.Synchronized;

@Controller
@RequestMapping("quotations")
public class QuotationController extends BaseWebController {

	public static final Logger LOG = LoggerFactory.getLogger(QuotationController.class);

	@Autowired
	IlfQuotService quotService;

	@Autowired
	IlfQuotPlanService planService;

	@ResponseBody
	@RequestMapping(value = "insertdata.json")
	public Map<String, Object> insertData(@RequestBody IlfQuot quot, HttpSession session) {
		String message = "";
		String user = gainUsername(session);
		if (StringUtils.isNotBlank(quot.getQuotNo())) {
			IlfQuot quot2=new IlfQuot();
			quot2.setQuotNo(quot.getQuotNo());
			//如果前端传了编号进来，这边需要比较 年龄，性别，是否吸烟这三个字段有没有被修改，如果被修改，则将数据库的其他数据清空（ilf_quot_plan）
			List<IlfQuot> quotList = quotService.getList(quot2);
			if (quotList.size()>0){

				IlfQuot quot1=quotList.get(0);//数据库的唯一一条记录
//				System.out.println("age="+quot1.getQuotFinsuredAge()+"       age1="+quot.getQuotFinsuredAge());
////				System.out.println("性別="+quot1.getQuotFinsuredGender()+"        性別="+quot.getQuotFinsuredGender());
////				System.out.println("是否吸烟="+quot1.getQuotFinsuredSmoker()+"        是否吸烟="+quot.getQuotFinsuredSmoker());
////				System.out.println("年期="+quot1.getQuotYears()+"        年期="+quot.getQuotYears());

				if(!quot1.getQuotFinsuredAge().equals(quot.getQuotFinsuredAge())     ||    //   数据库年龄    !=    界面传入的年龄   or
						!quot1.getQuotFinsuredGender().equals(quot.getQuotFinsuredGender())  ||//   数据库性别    !=    界面传入的性别   or
						!quot1.getQuotFinsuredSmoker().equals(quot.getQuotFinsuredSmoker())    //   数据库是否吸烟    !=    界面传入的吸烟   or
					      ){
					System.out.println("第一個界面的擬被保人其中有一個值被修改了，那麽就得重新選擇基本計劃，第二個頁面重選");
					//清空选择了的基本计划和年期
					quot.setQuotPlan("");
					quot.setQuotYears("");
					quot.setQuotCcy("");
					quot.setQuotTotalPrem(new BigDecimal(0));
					quot.setQuotTotalPremAnn(new BigDecimal(0));
					//清空其他表的数据
					Criteria c=new Criteria();
					c.addWhere(IlfQuotPlan.DBStrQuplanNo,quot.getQuotNo());
					planService.deleteBy(c);

				}else{
				    if(quot.getQuotYears().equals("")){
                        quot.setQuotYears(quot1.getQuotYears());
                    }
					if(!quot.getQuotYears().equals(quot1.getQuotYears())){//第一个界面无改动，第二个界面的值判断一是否改了年期，如果改了
						System.out.println("第二个界面的值判断一是否改了年期，如果改了，那麽就得清空第三個界面輸入的舊數據");

						//清空其他表的数据，下一页的值
						Criteria c=new Criteria();
						c.addWhere(IlfQuotPlan.DBStrQuplanNo,quot.getQuotNo());
						planService.deleteBy(c);
					}

				}
			}else{
				//清空其他表的数据
				Criteria c=new Criteria();
				c.addWhere(IlfQuotPlan.DBStrQuplanNo,quot.getQuotNo());
				planService.deleteBy(c);
				System.out.println("清空第三個界面輸入的舊數據");

			}

			quot.setQuotAdate(new Date());
			quot.setQuotAuser(user);
			quotService.update(quot);
			message = "update success.";
		} else {
			quot.setQuotNo(createQuotNo());
			quot.setQuotAdate(new Date());
			quot.setQuotAuser(user);
			quot.setQuotCdate(new Date());
			quot.setQuotCuser(user);

			quotService.insert(quot);
			message = "insert success.";
		}

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("quotNo", quot.getQuotNo());
		return this.success(message, body, 1000);
	}

	@ResponseBody
	@RequestMapping(value = "insertplan.json")
	public Map<String, Object> insertPlan(@RequestBody QuationProd prod, HttpSession session) {

		IlfQuot quot = new IlfQuot();
		String user = gainUsername(session);
		quot.setQuotNo(prod.getQuotNo());
		quot.setQuotPlanWaiver(prod.getQuotPlanWaiver());
		quot.setQuotTotalPrem(prod.getQuotTotalPrem());
		quot.setQuotTotalPremAnn(prod.getQuotTotalPremAnn());
		quot.setQuotAdate(new Date());
		quot.setQuotAuser(user);
		quotService.update(quot);

		Criteria c = new Criteria();
		c.addWhere(IlfQuotPlan.DBStrQuplanNo, prod.getQuotNo());
		planService.deleteBy(c);

		IlfQuotPlan plan = new IlfQuotPlan();
		plan.setQuplanNo(prod.getQuotNo());
		plan.setQuplanPlanCode(prod.getQuotPlanCode());
		plan.setQuplanAdate(new Date());
		plan.setQuplanAuser(user);
		plan.setQuplanCdate(new Date());
		plan.setQuplanCuser(user);
		int i = 0;
		for (Code code : prod.getQuotplanList()) {
			if(i == 1 && StringUtils.isNotBlank(prod.getQuotPlanWaiver())) {
				i++;
			}
			if(prod.getQuotPlanCode().equals("LT") && code.getQuplanRiderCode().equals("W3001")) {
				plan.setQuplanSeqno(1);
			} else {
				plan.setQuplanSeqno(i);
			}
			
			plan.setQuplanSumInsured(code.getQuplanSumInsured());
			plan.setQuplanAnnPremium(code.getQuplanAnnPremium());
			i++;
			if(code.getQuplanTermRiderIndex().equals("Y")) {
				plan.setQuplanRiderClass("*");
				plan.setQuplanRiderClassDesc("*");
				plan.setQuplanRiderCode(code.getQuplanRiderClass());
				plan.setQuplanRiderCodeDesc(code.getQuplanRiderClassDesc());
				planService.insert(plan);
				continue;
			}
			plan.setQuplanRiderCode(code.getQuplanRiderCode());
			plan.setQuplanRiderCodeDesc(code.getQuplanRiderCodeDesc());
			plan.setQuplanRiderClass(code.getQuplanRiderClass());
			plan.setQuplanRiderClassDesc(code.getQuplanRiderClassDesc());
			planService.insert(plan);
		}
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("quotNo", prod.getQuotNo());
		return this.success("insert success.", body, 1000);
	}

	@ResponseBody
	@RequestMapping(value = "editinsured.json")
	public Map<String, Object> editInsured(@RequestBody QuationProd prod, HttpSession session) {

		String no = createQuotNo();
		String user = gainUsername(session);
		Criteria cq = new Criteria();
		cq.addWhere(IlfQuot.DBStrQuotNo, prod.getQuotNo());
		IlfQuot quot = quotService.getOneBy(cq);
		quot.setQuotNo(no);
		quot.setQuotStatus(null);
		quot.setQuotAdate(new Date());
		quot.setQuotAuser(user);
		quot.setQuotCdate(new Date());
		quot.setQuotCuser(user);
		quotService.insert(quot);

		IlfQuotPlan quplan = new IlfQuotPlan();
		quplan.setQuplanNo(prod.getQuotNo());
		List<IlfQuotPlan> planList = planService.getList(quplan);
		for (IlfQuotPlan plan : planList) {
			plan.setQuplanNo(no);
			plan.setQuplanAdate(new Date());
			plan.setQuplanAuser(user);
			plan.setQuplanCdate(new Date());
			plan.setQuplanCuser(user);
			planService.insert(plan);
		}

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("quotNo", no);
		return this.success("edit success.", body, 1000);
	}

	@ResponseBody
	@RequestMapping(value = "showformtablelist.json")
	public Map<String, Object> showFormTableList(@RequestBody IlfQuot quot) throws ApplicationException {

		List<IlfQuot> quotList = quotService.getList(quot);
		Map<String, Object> mapStr = new HashMap<String, Object>();
		mapStr.put("tabList", quotList);
		return success(mapStr);

	}

	@ResponseBody
	@RequestMapping(value = "showquotdetail.json")
	public Map<String, Object> showQuotDetail(@RequestBody IlfQuot quot) throws ApplicationException {

		//Step 1
		List<IlfQuot> quotList = quotService.getList(quot);
		IlfQuotPlan plan = new IlfQuotPlan();
		plan.setQuplanNo(quot.getQuotNo() != null ? quot.getQuotNo() : "");
		List<IlfQuotPlan> planList = planService.getList(plan);
		
		Map<String, Object> mapStr = new HashMap<String, Object>();
		mapStr.put("quotDetail", quotList.size() > 0 ? quotList.get(0) : null);
		mapStr.put("planList", planList);

		return success(mapStr);

	}
	
	public @Synchronized String createQuotNo() {
		Criteria c = new Criteria();
		c.addDescOrder(IlfQuot.DBStrQuotNo);
		IlfQuot quot = quotService.getOneBy(c);

		Calendar cal = Calendar.getInstance();
		String year = cal.get(Calendar.YEAR) + "";
		String quotno = "";
		if (quot != null) {
			quotno = quot.getQuotNo();
			String yy = quotno.substring(4, 8);
			if (yy.equals(year)) {
				int no = Integer.parseInt(quotno.substring(8)) + 1;
				if (no < 10) {
					quotno = "00000" + no;
				} else if (no < 100) {
					quotno = "0000" + no;
				} else if (no < 1000) {
					quotno = "000" + no;
				} else if (no < 10000) {
					quotno = "00" + no;
				} else if (no < 100000) {
					quotno = "0" + no;
				} else {
					quotno = "" + no;
				}
			} else {
				quotno = "000001";
			}
		} else {
			quotno = "000001";
		}
		return "LFH-" + year + quotno;
	}
	
	public String gainUsername(HttpSession session) {
		LoginProfile login = null;
		try {
			login = SessionManager.getUser(session);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		if(login != null) {
			return login.getLoginId();
		}else {
			return "BANK001";
		}
	}

}
