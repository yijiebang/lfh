package com.reinfo.ipoly.module.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;

import com.reinfo.ipoly.module.models.ProdCountryCcy;
import com.reinfo.ipoly.module.models.ProdCountryMod;
import com.reinfo.ipoly.module.models.ProdCovLine;
import com.reinfo.ipoly.module.models.ProdCovTab;
import com.reinfo.ipoly.module.services.ProdCountryCcyService;
import com.reinfo.ipoly.module.services.ProdCountryModService;
import com.reinfo.ipoly.module.services.ProdCovLineService;
import com.reinfo.ipoly.module.services.ProdCovTabService;

@RestController
@RequestMapping(value = "prodCovLine")
public class ProdCovLineController extends BaseWebController {
    public static final Logger LOG = LoggerFactory.getLogger(ProdCovLineController.class);

    @Autowired
    protected ProdCovLineService prodLineService;
    
    @Autowired
    protected ProdCountryCcyService prodCountryCcyService;

    @Autowired
    protected ProdCountryModService prodCountryModService;
    
    @Autowired
    protected ProdCovTabService prodCovTabService;
    
    
    @ResponseBody
    @RequestMapping(value = "showlinelist.json")
    public Map<String, Object> showLineList(@RequestBody ProdCovLine line) throws ApplicationException {
        List<ProdCovLine> prodcovlineList = prodLineService.getList(line);
        List<Map<String,Object>> prodList = new ArrayList<Map<String,Object>>();
        for(ProdCovLine item : prodcovlineList) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("text", item.getCovLineCode()+" - "+item.getCovLineName());
			map.put("value", item.getCovLineCode());	 
			prodList.add(map);
		}
        
        Map<String,Object> mapStr = new HashMap<String,Object>();
		mapStr.put("prodList", prodList);
		
        return success(mapStr);
    }
    
    @ResponseBody
    @RequestMapping(value = "showccylist.json")
    public Map<String, Object> showCcyList(@RequestBody ProdCountryCcy ccy, HttpSession session) throws ApplicationException {
        List<ProdCountryCcy> ccyList = prodCountryCcyService.getDataPageBy(Criteria.newCriteria().addWhere(ProdCountryCcy.DBStrCovCode, ccy.getCovCode())
        		.addAscOrder(ProdCountryCcy.DBStrCovCode).addDescOrder(ProdCountryCcy.DBStrSeq));
        	
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(ProdCountryCcy item : ccyList) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("text", item.getCcy());
			map.put("value", item.getCcy());
			list.add(map);
		}
        
        Map<String,Object> mapStr = new HashMap<String,Object>();
		mapStr.put("ccyList", list);
		
        return success(mapStr);
    }
    
    @ResponseBody
    @RequestMapping(value = "showpaymodelist.json")
    public Map<String, Object> showPayModeList(@RequestBody ProdCountryMod mode, HttpSession session) throws ApplicationException {
        List<ProdCountryMod> modeList = prodCountryModService.getDataPageBy(Criteria.newCriteria().addWhere(ProdCountryMod.DBStrCovCode,mode.getCovCode()).
        		addAscOrder(ProdCountryMod.DBStrCovCode).addAscOrder(ProdCountryMod.DBStrPayMode));//prodCountryModService.getList(mode);
        		
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(ProdCountryMod item : modeList) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("text", item.getPayMode()+" - "+item.getModeNameOth());
			map.put("value", item.getPayMode());
			list.add(map);
		}
        
        Map<String,Object> mapStr = new HashMap<String,Object>();
		mapStr.put("modeList", list);
		
        return success(mapStr);
    }


    @ResponseBody
    @RequestMapping(value = "showproductlist.json")
    public Map<String, Object> showProductList(@RequestBody ProdCovTab tab, HttpSession session) throws ApplicationException {
        List<ProdCovTab> proList = prodCovTabService.getList(tab);
        		                   //prodCovTabService.getDataPageBy(Criteria.newCriteria().addWhere(ProdCovTab.DBStrProductLine, tab.getProductLine()).
        		                   //addAscOrder(ProdCovTab.DBStrCovCode).addAscOrder(ProdCovTab.DBStrCovCodeDisp));// 
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(ProdCovTab item : proList) {
        		Map<String,Object> map = new HashMap<String,Object>();
    			map.put("text", tab.getGender().equals("女")?(item.getPolMattFemale()!=null?+item.getPolMattFemale()+"年期 ":""):(item.getPolMattMale()!=null?item.getPolMattMale()+"年期 ":""));
    			map.put("value", item.getCovCode());
    			list.add(map);
		}
        
        Map<String,Object> mapStr = new HashMap<String,Object>();
		mapStr.put("tabList", list);
		
        return success(mapStr);
    }

}
