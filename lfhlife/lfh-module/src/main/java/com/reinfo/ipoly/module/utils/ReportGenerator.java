package com.reinfo.ipoly.module.utils;

import org.joda.time.format.PeriodFormatter;
import javax.xml.parsers.DocumentBuilder;
import java.util.Iterator;
import java.util.List;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.ReadableInstant;
import org.joda.time.Period;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import com.aspose.words.IMailMergeDataSourceRoot;
import com.aspose.words.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.XML;
import org.json.JSONObject;
import com.google.gson.JsonElement;
import java.util.LinkedList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import java.io.DataOutputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Properties;

public class ReportGenerator implements Runnable {
	private Boolean isDebug;
	protected Properties prop;
	protected Socket clientSocket;
	protected String serverText;

	public ReportGenerator(final Socket clientSocket, final String serverText, final Properties prop) {
		this.isDebug = false;
		this.prop = null;
		this.clientSocket = null;
		this.serverText = null;
		this.clientSocket = clientSocket;
		this.serverText = serverText;
		this.prop = prop;
		if (prop != null) {
			this.isDebug = Boolean.parseBoolean(prop.getProperty("isDebug"));
		}
	}

	@Override
	public void run() {
		DateTime startTime = null;
		DateTime pauseTime1 = null;
		DateTime pauseTime2 = null;
		DateTime pauseTime3 = null;
		DateTime pauseTime4 = null;
		DateTime endTime = null;
		BufferedReader reader = null;
		DataOutputStream outStream = null;
		try {
			reader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream(), "UTF-8"));
			outStream = new DataOutputStream(this.clientSocket.getOutputStream());
			final String inputData = reader.readLine();
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
			final String secretPath = obj.get("secretPath").getAsString();
			final String licensePath = obj.get("licensePath").getAsString();
			final String ivPath = obj.get("ivPath").getAsString();
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
			final Document dstDoc = new Document(mainDocumentPath);
			for (final String documentPath : documentPathList) {
				dstDoc.appendDocument(new Document(documentPath), 1);
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
			final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			dstDoc.save((OutputStream) byteStream, 40);
			outStream.write(byteStream.toByteArray());
			outStream.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (outStream != null) {
				try {
					outStream.writeUTF(String.format("{\"error\":\"%s\"}", ex.getMessage()));
					outStream.flush();
				} catch (IOException ex2) {
					ex2.printStackTrace();
				}
			}
		} finally {
			try {
				if (outStream != null) {
					outStream.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (this.clientSocket != null) {
					this.clientSocket.close();
				}
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
	}
}