package com.reinfo.ipoly.module.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.aspose.words.Document;
import com.aspose.words.IMailMergeDataSourceRoot;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.reinfo.ipoly.common.util.ResourceUitl;
import com.reinfo.ipoly.module.controllers.ProdCovClassController;

public class MailMerge {

	public static final Logger logger = LoggerFactory.getLogger(ProdCovClassController.class);
	
	private static boolean isDebug = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MailMerge().generateReport("");

	}
	
	public byte[] generateReport(String inputData) {
		DateTime startTime = null;
		DateTime pauseTime1 = null;
		DateTime pauseTime2 = null;
		DateTime pauseTime3 = null;
		DateTime pauseTime4 = null;
		DateTime endTime = null;
		BufferedReader reader = null;
		//DataOutputStream outStream = null;
		final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		try {
			String templatePath = ResourceUitl.getConfigPath() + "/templates/";
			
			logger.info("templatePath="+templatePath);
			//reader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream(), "UTF-8"));
	
			//outStream = new DataOutputStream(this.clientSocket.getOutputStream());
			//final String inputData = ""; //reader.readLine();
			//File sourceFile = new File(ResourceUitl.getConfigPath() + "/templates/rpt_client.jasper");
			/*reader = new BufferedReader(new FileReader(templatePath+"ppswlp.json"));			
			StringBuilder stringBuilder = new StringBuilder();
			String s = "";
            while ((s = reader.readLine()) != null) {
                stringBuilder.append(s);
            }
 
            String inputData = stringBuilder.toString();*/
			if (this.isDebug) {
				System.out.println("==== Report Generation [START] ==== ");
				startTime = new DateTime();
				System.out.println(inputData);
			}
			final Gson gson = new Gson();
			final JsonObject obj = (JsonObject) gson.fromJson(inputData, (Class) JsonObject.class);
			final String mainDocumentPath = obj.get("mainDocumentPath").getAsString();
			final JsonArray documentPaths = obj.get("documentPathList").getAsJsonArray();
			final JsonArray removeSections = (obj.get("removeSectionList") == null)
					? new JsonArray()
					: obj.get("removeSectionList").getAsJsonArray();
			final String secretPath = templatePath+"secret.mcc"; //obj.get("secretPath").getAsString();
			final String licensePath = templatePath+"license.mcc"; //obj.get("licensePath").getAsString();
			final String ivPath = templatePath+"iv.mcc"; //obj.get("ivPath").getAsString();
			final List<String> documentPathList = new LinkedList<String>();
			for (final JsonElement element : documentPaths) {
				documentPathList.add(element.getAsString());
			}
			final List<Integer> removeSectionList = new LinkedList<Integer>();
			for (final JsonElement element2 : removeSections) {
				removeSectionList.add(element2.getAsInt());
			}
			if (this.isDebug) {
				pauseTime1 = new DateTime();
			}
			final String ppsData = gson.toJson(obj.get("data"));
			final JSONObject json = new JSONObject(ppsData);
			final String xml = XML.toString((Object) json);
			if (this.isDebug) {
				System.out.println(ppsData);
				System.out.println(xml);
			}
			final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			final org.w3c.dom.Document xmlData = builder.parse(new InputSource(new StringReader(xml)));
			if (this.isDebug) {
				pauseTime2 = new DateTime();
			}
			final LicenseManager licenseManager = LicenseManager.getInstance();
			licenseManager.setLicense(secretPath, licensePath, ivPath);
			final Document dstDoc = new Document(templatePath+mainDocumentPath);
			for (final String documentPath : documentPathList) {
				dstDoc.appendDocument(new Document(templatePath+documentPath), 1);
			}
			for (final Integer removeSection : removeSectionList) {
				dstDoc.getSections().get((int) removeSection).remove();
			}
			if (this.isDebug) {
				pauseTime3 = new DateTime();
			}
			dstDoc.getMailMerge().executeWithRegions((IMailMergeDataSourceRoot) new XmlMailMergeDataSet(xmlData));
			if (this.isDebug) {
				pauseTime4 = new DateTime();
			}
			//dstDoc.save.save("LFH-190829.docx");
			
			dstDoc.save((OutputStream) byteStream, 40);
			
			//outStream.write(byteStream.toByteArray());
			//outStream.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			/*if (outStream != null) {
				try {
					outStream.writeUTF(String.format("{\"error\":\"%s\"}", ex.getMessage()));
					outStream.flush();
				} catch (IOException ex2) {
					ex2.printStackTrace();
				}
			}*/
		} finally {
			try {				
				/*if (outStream != null) {
					outStream.close();
				}*/
				if (reader != null) {
					reader.close();
				}
				//if (this.clientSocket != null) {
				//	this.clientSocket.close();
				//}
			} catch (IOException ex3) {
				ex3.printStackTrace();
			}
			if (this.isDebug) {
				endTime = new DateTime();
				System.out.println("==== Report Generation [ END ] ==== ");
				final Period period = new Period((ReadableInstant) startTime, (ReadableInstant) endTime);
				final Period period2 = new Period((ReadableInstant) startTime, (ReadableInstant) pauseTime1);
				final Period period3 = new Period((ReadableInstant) pauseTime1, (ReadableInstant) pauseTime2);
				final Period period4 = new Period((ReadableInstant) pauseTime2, (ReadableInstant) pauseTime3);
				final Period period5 = new Period((ReadableInstant) pauseTime3, (ReadableInstant) pauseTime4);
				final Period period6 = new Period((ReadableInstant) pauseTime4, (ReadableInstant) endTime);
				final PeriodFormatter formatter = new PeriodFormatterBuilder().appendSeconds().appendSuffix("s ", "s ")
						.appendMillis3Digit().appendSuffix("ms ", "ms ").printZeroNever().toFormatter();
				System.out.println(
						String.format("==== Total time spent: %s ==== ", formatter.print((ReadablePeriod) period)));
				System.out.println(String.format("==== Time spent for append documents: %s ==== ",
						formatter.print((ReadablePeriod) period2)));
				System.out.println(String.format("==== Time spent for reading config: %s ==== ",
						formatter.print((ReadablePeriod) period3)));
				System.out.println(String.format("==== Time spent for prepare XML: %s ==== ",
						formatter.print((ReadablePeriod) period4)));
				System.out.println(String.format("==== Time spent for mail merge: %s ==== ",
						formatter.print((ReadablePeriod) period5)));
				System.out.println(String.format("==== Time spent for output pdf: %s ==== ",
						formatter.print((ReadablePeriod) period6)));
			}
		}
		
		return byteStream.toByteArray();
	}

}
