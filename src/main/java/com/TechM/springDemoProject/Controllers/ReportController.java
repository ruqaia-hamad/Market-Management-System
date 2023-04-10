package com.TechM.springDemoProject.Controllers;


import com.TechM.springDemoProject.Services.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "Report")
@Component
public class ReportController {


    @Autowired
    MarketService marketService;

    @Autowired
    ReportService reportService;
    @Autowired
    CustomerService customerService;

    @Autowired
    ItemService itemService;
    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "MarketsReport", method = RequestMethod.GET)
    public String generateMarketsReport() throws FileNotFoundException, JRException {

        return reportService.generateReport();
    }


    @RequestMapping(value = "MarketsTotalRevenueReport", method = RequestMethod.GET)
    public String generateReportForTotal() throws FileNotFoundException, JRException {

        return reportService.generateReportForTotal();
    }
    @RequestMapping(value = "TopSellingItemReport", method = RequestMethod.GET)
    public String generateReportForTopSellingItem() throws FileNotFoundException, JRException {

        return reportService.generateReportForTopSellingItem();
    }



    @RequestMapping(value = "ItemDistribution", method = RequestMethod.GET)
    public String generateReportForItemDistribution() throws FileNotFoundException, JRException {

        return reportService.generateReportForItemDistribution();
    }


    @RequestMapping(value = "InvoicesReport", method = RequestMethod.GET)
    public String generateInvoicesReport() throws FileNotFoundException, JRException {

        return reportService.generateReportForInvoices();
    }

    @PostMapping("/{id}/calculate-total-price")
    public ResponseEntity<String> calculateTotalPrice(@PathVariable("id") Integer invoiceId) {
        invoiceService.calculateAndSaveTotalPrice(invoiceId);
        return ResponseEntity.ok("Total price calculated and saved successfully.");
    }

    @RequestMapping(value = "customerPerformanceReport", method = RequestMethod.GET)
    public String generateReportForCustomerPerformance() throws FileNotFoundException, JRException {

        return reportService.generateReportForCustomerPerformance();
    }

    @RequestMapping(value = "MarketCustomerCountReport", method = RequestMethod.GET)
    public String     getMarketCustomerCountReport() throws FileNotFoundException, JRException {

        return reportService.getMarketCustomerCountReport();
    }


    @RequestMapping(value = "TopMarketsReport", method = RequestMethod.GET)
    public String generateTopMarketsReport() throws FileNotFoundException, JRException {

        return reportService.generateTopMarketsReport();
    }


    @RequestMapping(value = "CustomersReport", method = RequestMethod.GET)
    public String generateReportForCustomersReport() throws FileNotFoundException, JRException {

        return reportService.generateReportForCustomersReport();
    }


    @RequestMapping(value = "TopSellingITemInMarket", method = RequestMethod.GET)
    public String generateReportForTopSellingITemInMarket() throws FileNotFoundException, JRException {

        return reportService.generateReportForTopSellingITemInMarket();
    }


}
