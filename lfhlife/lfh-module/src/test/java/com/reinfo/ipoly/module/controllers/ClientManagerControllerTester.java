package com.reinfo.ipoly.module.controllers;

import org.junit.Test;

import com.reinfo.ipoly.base.BaseControllerTest;
import com.reinfo.ipoly.common.util.FileUtil;

public class ClientManagerControllerTester extends BaseControllerTest {

	@Test
	public void test_getList() {
		String url = "clientManager/getList.json";
		String parameter = "{'cliLname':'C00','cliCty':'MAC','cliType':'C','page':{'currentPageNo':'2'}}";
		post(url, parameter);
	}
	
	@Test
    public void test_clientDownload() {
        String url = "clientManager/clientDownload.json?online=false&cliLnameFrom=C00&cliLnameTo=C01&cliType=C";
        get(url);
    }

	@Test
	public void test_getClifl() {
		String url = "clientManager/getClifl.json?cliCode=C00379";
		get(url);
	}

	@Test
	public void test_getClientType() {
		String url = "clientManager/getClientType.json";
		get(url);
	}

	@Test
	public void test_addClientManager() {
		String url = "clientManager/addClientManager.json";
		String parameter = "{'cliLname': ' ','cliSname': ' ','cliAddr1': ' ','cliAddr2': ' ','cliAddr3': ' ','cliAddr4': ' ','cliCty': 'MAC','cliZip': ' ','cliType': 'C','cliGroup': ' ','cliTelidd': '853','cliTel': ' ','cliFaxidd': ' ','cliFax': ' ','cliTlxidd': ' ','cliTlx': ' ','cliEmail': ' ','cliBank': ' ','cliAtnac': ' ','cliAtnclm': ' ','cliAtnuw': ' ','cliAtnfac': ' ','cliAtntty': ' ','cliCapccy': 'MOP','cliNote': 'POUL LEE ENTERPRISE CO. LTD. ','cliSt': 'A','cliOffice': 'CIM','cliStaff': ' '}";
		post(url, parameter);
	}

	@Test
	public void test_updateClientManager() {
		String url = "clientManager/updateClientManager.json";
		String parameter = "{'cliCode':'C00379','cliNote':'POUL LEE ENTERPRISE CO. LTD.'}";
		post(url, parameter);
	}

	@Test
	public void test_getAttentions() {
		String url = "clientManager/getAttentions.json?cliCode=C00379";
		get(url);
	}

	@Test
	public void test_getAttentionInfo() {
		String url = "clientManager/getAttentionInfo.json";
		String parameter = "{'claCode':'C00379','claItem':'001'}";
		post(url, parameter);
	}

	@Test
	public void test_addOrUpdateClafl() {
		String url = "clientManager/addOrUpdateClafl.json";
		String parameter = "{'claCode':'C00379','claName':'POUL LEE ENTERPRISE CO. LTD.','claName':' ','claLast':' ','claFirst':' ','claTitle':' ','claDeptname':' ','claTelidd':' ','claTel':' ','claFaxidd':' ','claFax':' ','claEmail':' ','claEname':' ','claNote':' ','claMail1':' ','claMail2':' ','claMail3':' ','claMail4':' ','claMail5':' ','claMail6':' ','claMail7':' ','claMail8':' ','claMail9':' '}";
		post(url, parameter);
	}

	@Test
	public void test_getTchfl() {
		String url = "clientManager/getTchfl.json";
		get(url);
	}

	@Test
	public void test_getEFSList() {
		String url = "clientManager/getEFSList.json?cliCode=C00379";
		get(url);
	}

	@Test
	public void test_EFS_download() {
		String url = hostName + "clientManager/EFS/download.json?cliCode=C00379&imgSeqno=1020";
		System.out.println(get(url));
	}

	@Test
	public void test_batchEFS() throws Exception {
		String base64 = FileUtil.getBase64Str("D:\\tmp\\test.jpg");
		String url = "clientManager/batchEFS.json";
		String parameter = "[{'imgClicode':'C00379','imgFileBase64':'" + base64
				+ "','imgType':'CLM','imgDesc':'this is test doc','imgFileName':'test.jpg','imgFilePath':'D:/tmp/test.jpg','imgFileExt':'jpg'}]";
		post(url, parameter);
	}

	@Test
	public void test_getReportStatistics() {
		String url = "clientManager/getReportStatistics.json?startYear=2000&endYear=2001";
		get(url);
	}

	@Test
	public void test_getStatisticsCode() {
		String url = "clientManager/getStatisticsCode.json?cliCode=106171";
		get(url);
	}

	@Test
	public void test_batchK3ufl() {
		String url = "clientManager/batchK3ufl.json";
		String parameter = "[{'k3uCliCode':'075625','k3uSeq':1,'k3uInternal':'Y'},{'k3uCliCode':'075625','k3uStatType':'LILC','k3uInternal':'N'}]";
		post(url, parameter);
	}

	@Test
	public void test_getInsuredUWInquiry() {
		String url = "clientManager/getInsuredUWInquiry.json?cliCode=106171";
		get(url);
	}

	@Test
	public void test_getStatusHistory() {
		String url = "clientManager/getStatusHistory.json?cliCode=106171";
		post(url, null);
	}
}
