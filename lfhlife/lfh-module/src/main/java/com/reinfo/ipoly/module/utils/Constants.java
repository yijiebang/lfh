package com.reinfo.ipoly.module.utils;

import java.util.HashMap;
import java.util.Map;

import com.reinfo.ipoly.module.models.ProdCovLine;
import com.reinfo.ipoly.module.models.ProdCovTab;
import com.reinfo.ipoly.module.models.QuationProd;

/**
 *     初始化的 常量类
 * @author Jerry
 *
 */
public class Constants {
     //跟據基本类别获取编号
	public static Map<String, Object> covTab_Map;
    //跟據cov_code_line获取名称（目前用于基本）
    public static Map<String, String> getProdCovLineMap2;
	//跟據cov_code_line获取名称（目前用于定期和危疾）
	public static Map<String, String> getProdCovLineMap;
	
	//页面信息保存
    public static Map<String, QuationProd> QuationProd_Map=new HashMap<String, QuationProd>();
    
    //建议书编号
    public static int sequence;
    
    //Product Type
    public static String[] PRODUCT_TYPE = new String[]{"BASIC_PLAN", "LEVEL_TERM", "ACCIDENTAL_INDEMNITY_PROTECTION_PLAN", 
    		"ACCIDENTAL_DEATH_AND_DISMEMBERMENT_PROTECTION_PLAN", "ACCIDENTAL_DEATH_BENEFIT", "DREAD_DISEASE_COVERAGE", 
    		"HOSPITAL_AND_SURGICAL_BENEFIT", "HOSPITAL_INCOME_BENEFIT", "BASIC_PLAN_WAIVER_OF_PREMIUM", 
    		"FREE_LEVEL_TERM", "LEVEL_TERM_WAIVER_OF_PREMIUM", "PAYER_BENEFIT"};
}
