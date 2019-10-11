package com.reinfo.ipoly.module.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.reinfo.ipoly.module.mappers.ProdCovInitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.reinfo.ipoly.module.models.ProdCovLine;
import com.reinfo.ipoly.module.models.ProdCovTab;
 
/**
 *    初始化加載表數據，提高程序效率
 * @author Jerry
 *
 */
@Component
public class ProdCovinit implements ApplicationRunner{
	public static final Logger LOG = LoggerFactory.getLogger(ProdCovinit.class);

	@Autowired
	ProdCovInitMapper prodInitDao;
	  

	@Override
	public void run(ApplicationArguments args) throws Exception {
	    System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 ProdCovRidinit   1 <<<<<<<<<<<<<");
        
	    //根据编码取cov_tab表得code ,WLP-1001
	    List<ProdCovLine> nlist=prodInitDao.covLineList("N");
	    Map<String, Object> map=new HashMap<String, Object>();
	    for (ProdCovLine line:nlist) {
			ProdCovTab tab=prodInitDao.covTabList(line.getCovLineCode());//WLP
			if(tab!=null) {
				map.put(line.getCovLineCode(),tab.getCovCode()); //--WLP-1001
			}
		}
	     
	    Constants.covTab_Map=map;


	    //类别对应描述,cov_line_code-cov_line_name
		Map<String, String> map2=new LinkedHashMap<String, String>();

		List<ProdCovLine> Ylist=prodInitDao.covLineList("Y");
		for (ProdCovLine line:Ylist) {

			map2.put(line.getCovLineCode(),line.getCovLineName()); //--DD	危疾
		}
	    Constants.getProdCovLineMap=map2;


		//类别对应描述,cov_line_code-cov_line_name
		Map<String, String> map3=new LinkedHashMap<String, String>();

		List<ProdCovLine> nlist2=prodInitDao.covLineList("N");
		for (ProdCovLine line:nlist2) {

			map3.put(line.getCovLineCode(),line.getCovLineName()); //--
		}
		Constants.getProdCovLineMap2=map3;

	    LOG.info("========初始化完成. ========");
	}
	

}
