package com.reinfo.ipoly.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reinfo.ipoly.common.config.IpolyConfig;

/**
 * 生成PDF，通过freemarker模板
 * 
 * @author zf
 */
public class PdfTool {
	public static final Logger LOG = LoggerFactory.getLogger(PdfTool.class);

	/**
	 * 使用第三方工具wkhtmltopdf 生成pdf
	 * 
	 * @param url
	 *            html的url地址
	 * @param pdfPath
	 *            pdf生成路径
	 * @throws Exception
	 */
	public static void executePdf(String url, String pdfPath) throws Exception {
		LOG.debug("url : {}",url);
		LOG.debug("pdfPath : {}",pdfPath);
		String toPdfTool  = "wkhtmltopdf";
		String system = System.getProperty("os.name");
		if (system.indexOf("Windows") != -1) {
			toPdfTool = IpolyConfig.getInstance().get("wkhtmltopdf.dir") + "bin//wkhtmltopdf.exe";
		}
		StringBuffer command = new StringBuffer();
		command.append(toPdfTool);
		command.append(" ");
		//设置转换参数
		command.append(" --debug-javascript ");
		command.append(" --javascript-delay 3000 ");
		command.append(" --margin-top 0mm ");
		command.append(" --margin-left 0mm ");
		command.append(" --margin-right 0mm ");
		command.append(" --margin-bottom 0mm ");
		
		//页面网址url
		command.append(url);
		command.append(" ");
		command.append(pdfPath);
		Process process = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			LOG.info("开始PDF生成 ：" + command);
			process = Runtime.getRuntime().exec(command.toString());
			is = process.getErrorStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				LOG.info(line);
			}
			int exitVal = process.waitFor();
			LOG.info("--------" + exitVal);
		} catch (Exception e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		LOG.info("完成PDF生成 ");
	}
	
	/**
	 * 使用第三方工具wkhtmltoimage 生成image
	 * @param url
	 * @param pdfPath
	 * @throws Exception
	 */
	public static void executeImage(String url, String pdfPath) throws Exception {
		LOG.debug("url : {}",url);
		LOG.debug("pdfPath : {}",pdfPath);
		String toPdfTool  = "wkhtmltoimage";
		String system = System.getProperty("os.name");
		if (system.indexOf("Windows") != -1) {
			toPdfTool = IpolyConfig.getInstance().get("wkhtmltopdf.dir") + "bin//wkhtmltoimage.exe";
		}
		StringBuffer command = new StringBuffer();
		command.append(toPdfTool);
		command.append(" ");
		//设置转换参数
		
		
		//页面网址url
		command.append(url);
		command.append(" ");
		command.append(pdfPath);
		Process process = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			LOG.info("开始image生成 ：" + command);
			process = Runtime.getRuntime().exec(command.toString());
			process.waitFor();
			is = process.getErrorStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				LOG.info(line);
			}
			int exitVal = process.waitFor();
			LOG.info("--------" + exitVal);
		} catch (Exception e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		LOG.info("完成image生成 ");
	}
	
	/**
	 * 使用第三方工具wkhtmltoimage,带有参数  生成image
	 * @param url
	 * @param pdfPath
	 * @throws Exception
	 */
	public static void executeImageByParameter(String url, String pdfPath) throws Exception {
		LOG.debug("url : {}",url);
		LOG.debug("pdfPath : {}",pdfPath);
		String toPdfTool  = "wkhtmltoimage";
		String system = System.getProperty("os.name");
		if (system.indexOf("Windows") != -1) {
			toPdfTool = IpolyConfig.getInstance().get("wkhtmltopdf.dir") + "bin//wkhtmltoimage.exe";
		}
		StringBuffer command = new StringBuffer();
		command.append(toPdfTool);
		command.append(" ");
		//设置转换参数
		command.append(" --crop-w ");
		command.append(" 750 ");
		//页面网址url
		command.append(url);
		command.append(" ");
		command.append(pdfPath);
		Process process = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			LOG.info("开始image生成 ：" + command);
			process = Runtime.getRuntime().exec(command.toString());
			process.waitFor();
			is = process.getErrorStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				LOG.info(line);
			}
			int exitVal = process.waitFor();
			LOG.info("--------" + exitVal);
		} catch (Exception e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		LOG.info("完成image生成 ");
	}

	public static void main(String[] args) throws Exception {
		//PdfTool.executePdf("http://www.jztest.cc/report.html?orderId=2937", "F:/test/test6.pdf");
		PdfTool.executeImageByParameter("http://www.jztest.cc/Job/share.html", "F:/test/test111.jpg");
	}

}