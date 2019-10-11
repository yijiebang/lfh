package com.reinfo.ipoly.module.controllers;

import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.mappers.ProdCovInitMapper;
import com.reinfo.ipoly.module.models.ProdCovTab;
import com.reinfo.ipoly.module.models.ProdPolFee;
import com.reinfo.ipoly.module.models.ProdPremRate;
import com.reinfo.ipoly.module.models.ProdRateParm;
import com.reinfo.ipoly.module.services.ProdCovTabService;
import com.reinfo.ipoly.module.services.ProdPolFeeService;
import com.reinfo.ipoly.module.services.ProdPremRateService;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 計算保費
 *  Calculate annual premium
 * @author jerry
 *
 */
@RestController
@RequestMapping(value = "prodPremRate")
public class ProdPremRateController extends BaseWebController {

	public static final Logger LOG = LoggerFactory.getLogger(ProdPremRateController.class);

	@Autowired
	ProdPremRateService premRateService;

	@Autowired
	ProdPolFeeService polFeeService;

	@Autowired
	ProdCovTabService prodCovTabService;

	@Autowired
	ProdCovInitMapper prodCovInitDao;

	@ResponseBody
	@RequestMapping(value = "getSumPremium.json")
	public Map<String, Object> getSumPremium(@RequestBody String jsonObject) throws ApplicationException {

		long starttimr=System.currentTimeMillis();
		Log.debug(jsonObject);
		String message = "success";
		int code = 1000;
		List<ProdRateParm> parmList = JSONObject.parseArray(jsonObject, ProdRateParm.class);
		for (ProdRateParm pp : parmList) {
	 		if (StringUtil.isBlank(pp.getCovCode())) {
	 			code = SystemCode.NO_DATA.getCode();
				message = SystemCode.NO_DATA.getMessage();
				throw new ApplicationException(code, "{}[covCode:{}]", message, jsonObject);//直接抛出错误信息，不进行下面的操作
			}
			BigDecimal sumPremium = new BigDecimal(0.00);
			BigDecimal rateScale  = new BigDecimal(0.00);
			BigDecimal ratePrem   = new BigDecimal(0.00);
			BigDecimal inputPremium = pp.getInputPremium();//输入保额
			//Rates are based on basic plans, gender, smoking, age and currency type
			Criteria c = new Criteria();
			if("Y".equals(pp.getCovTermRiderInd())){//等额定期,危疾 豁免保障都是沒有class,所以cov_class賦值为cov_code,所以进入这一步
 				c.addWhere(ProdPremRate.DBStrCovCode, pp.getCovClass());
			}else{//基本類型和其他類型cov_code都是自身的code
                c.addWhere(ProdPremRate.DBStrCovCode, pp.getCovCode());
			}
			if("Y".equals(pp.getDefaultval())){//有没有class        等额定期/危疾 豁免保障都沒有class
				c.addWhere(ProdPremRate.DBStrCovClass, "*");
			}else{
				c.addWhere(ProdPremRate.DBStrCovClass, pp.getCovClass());
			}
 			c.addWhere(ProdPremRate.DBStrSex, pp.getSex());
			c.addWhere(ProdPremRate.DBStrSmoke, pp.getSmoke());
			c.addWhere(ProdPremRate.DBStrCcy, pp.getCcy());
			c.addWhere(ProdPremRate.DBStrIssAge, pp.getIssAge());
			c.addWhere(ProdPremRate.DBStrStatus,"A");//可用
			ProdPremRate premRate = getPremiumRate(c);

 			if (premRate != null) {




				/*** 费率，规模 ***/
				ratePrem=premRate.getPremRate();

				//判斷是否基本計劃有輸入框，沒有則直接用查詢出來的費率=年繳保費
				ProdCovTab prodCovTab= prodCovInitDao.getProductLine(pp.getCovCode());
				String suminput="";
				if(prodCovTab!=null){
					suminput= prodCovTab.getSumInd();
 						if("B".equals(prodCovTab.getPlanInd()) && "N".equals(suminput)){
							sumPremium = ratePrem;
							pp.setSumPremium(sumPremium);
							continue;
						}


				}

				ProdCovTab tab=prodCovInitDao.getProductLine(pp.getCovCode());
				if(  "B".equals(tab.getPlanInd()) || "LTR".equals(tab.getProductLine())){//基本計劃\等額定期

					if( pp.getBasePlan().compareTo(BigDecimal.ZERO)==0){//==0

					}else{
						ratePrem =ratePrem.multiply(pp.getBasePlan());
					}

				}
				if("WP".equals(tab.getProductLine()) || "PB".equals(tab.getProductLine())){//豁免
					if(pp.getWppb().compareTo(BigDecimal.ZERO)==0){//==0

					}else{
						ratePrem =ratePrem.multiply(pp.getWppb());
					}

				}
				rateScale=new BigDecimal(premRate.getScale());
				if("N".equals(pp.getShowSumInsured())) {//rateMode没有
					sumPremium = ratePrem;
				}else {
					sumPremium = calculationPremium(inputPremium,ratePrem, rateScale,pp.getCovCode(),pp.getCcy());
 				}
					pp.setSumPremium(sumPremium);
			} else {
					code = SystemCode.NO_DATA.getCode();
					message = SystemCode.NO_DATA.getMessage();
			    	Log.error("在数据库中没有取到数据信息");
				    throw new ApplicationException(code, "{}[covCode:{}]", message, jsonObject);//直接抛出错误信息，不进行下面的操作
			}
		}
		/*************** output**************/
		Map<String, Object> mapOUT = new LinkedHashMap<>();
		mapOUT.put("message", message);
		mapOUT.put("body", parmList);
		mapOUT.put("responseCode", code);

		long endttimr=System.currentTimeMillis();
		long a=starttimr-endttimr;
		Log.info("接口耗时:"+a+"(毫秒)");
		return  mapOUT;
 	}

	/**
	 *   Rates are based on basic plans, gender, smoking, age and currency type
	 *   Get product premium rate And scale
	 *   获取产品保险费率和规模
	 * @param c
	 * @return
	 */
	private   ProdPremRate getPremiumRate(Criteria c) {
		ProdPremRate premRate = premRateService.getOneBy(c);
		return premRate;
	}

	/***
	 * 計算公式：（輸入）保额 * 费率 /1000(scale) + 保單费用
	 * @param inputPremium   ,premRate , scale ,polFee
	 * Get product premium rate
	 * @return
	 */
	//Get product premium rate
	private   BigDecimal calculationPremium(BigDecimal inputPremium, BigDecimal premRate, BigDecimal scale,String covCode,String ccy) {
		// Calculate annual premium
		BigDecimal p = inputPremium.multiply(premRate).divide(scale);

		// Get policy fee from DB
		BigDecimal policyFee=getPolicyFee(  covCode,  ccy);

		//Add extra charge
		BigDecimal premium=addFeeAndPremium( p,  policyFee);
		return premium.setScale(2,BigDecimal.ROUND_DOWN);//Keep two decimal places

	}

	/**
	 * Get policy fee from DB
	 * 获取保单费
	 * @param covCode
	 * @param ccy
	 * @return
	 */
	private BigDecimal getPolicyFee(String covCode,String ccy){
		Criteria fee = new Criteria();
		fee.addWhere(ProdPolFee.DBStrCovCode, covCode);
		fee.addWhere(ProdPolFee.DBStrCcy, ccy);
		ProdPolFee prodFee = polFeeService.getOneBy(fee);
		if(prodFee!=null) {
			return new BigDecimal(prodFee.getPolFee());
		}
       return new BigDecimal(0);
	}

	/**
	 * Add extra charge
	 * 增加额外费用
	 * @param premium
	 * @param policyFee
	 * @return
	 */
	private BigDecimal addFeeAndPremium(BigDecimal  premium,BigDecimal policyFee) {
		return premium.add(policyFee);
	}

}
