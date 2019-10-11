package com.reinfo.ipoly.module.report.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reinfo.ipoly.common.util.ResourceUitl;
import com.reinfo.ipoly.module.models.Clifl;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;


public class ClientReportUtil {
    private static Logger logger = LoggerFactory.getLogger(ClientReportUtil.class);

    /**
     * 会合并数据和报表模板生成pdf文件.
     * 
     * @param list
     * @return
     * @throws IOException
     */
    public static byte[] getReport(List<Clifl> list) throws Exception {
        List<JasperPrint> jpList = new ArrayList<JasperPrint>();

        // JasperPrint jpPolicy = null;
        String pdfFileName = "";
        InputStream isSchedule = null;
        InputStream isTravelBene = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            File sourceFile = new File(ResourceUitl.getConfigPath() + "/jasper/rpt_client.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(sourceFile);

            // isSchedule = ResourceUitl.openInputStream("classpath:jasp/rpt_client.jasper");
            pdfFileName = "client.pdf";
            Map<String, Object> params = new HashMap<String, Object>();

            JRDataSource jrdsTravelPrtBene = new JRBeanCollectionDataSource(list);// second page of travel
            JasperPrint jpTravelPrtBene = JasperFillManager.fillReport(jasperReport, params, jrdsTravelPrtBene);
            jpList.add(jpTravelPrtBene);

            // same function line 622 in PrintSchedule.java
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(SimpleExporterInput.getInstance(jpList));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setCreatingBatchModeBookmarks(true);
            exporter.setConfiguration(configuration);
            exporter.exportReport();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            if (isSchedule != null) {
                isSchedule.close();
            }
            if (isTravelBene != null) {
                isTravelBene.close();
            }
        }
        byte[] buff = outputStream.toByteArray();
        return buff;
    }

}
