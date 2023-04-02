package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.MarketRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    public static final String pathToReports = "C:\\Users\\user015\\Downloads\\Reports";
    @Autowired
    MarketRepository marketRepository;

    public String generateReport() throws FileNotFoundException,JRException {
        List<Market> marketList=marketRepository.getAllMarkets();
        File file = ResourceUtils.getFile("classpath:Market_System.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marketList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\Markets.pdf");
        return "Report generated : " + pathToReports+"\\Markets.pdf";
    }
}
