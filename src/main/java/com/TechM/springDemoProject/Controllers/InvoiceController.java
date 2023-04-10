package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.RequestObject.CustomerRequestForCreateCustomer;
import com.TechM.springDemoProject.RequestObject.InvoiceRequest;
import com.TechM.springDemoProject.Services.InvoiceService;
import com.TechM.springDemoProject.Services.ReportService;
import com.TechM.springDemoProject.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Invoice")
public class InvoiceController {


    @Autowired
    ReportService reportService;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    SlackClient slackClient;
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        for (Invoice invoice : invoices) {
            slackClient.sendMessage(String.format("Invoice  ID:"+ invoice.getId()));
            slackClient.sendMessage(String.format("Invoice  Email:"+ invoice.getEmail()));
            slackClient.sendMessage(String.format("Invoice  FAX:"+ invoice.getFax()));
            slackClient.sendMessage(String.format("Invoice  WEBSITE:"+ invoice.getWebsite()));
            slackClient.sendMessage(String.format("-----------------------------------"));


        }
        return invoices;
    }


    @RequestMapping(value = "Invoice/getById", method = RequestMethod.GET)
    public Invoice getInvoiceById(@RequestParam Integer invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        slackClient.sendMessage(String.format("Invoice  ID:"+ invoice.getId()));
        slackClient.sendMessage(String.format("Invoice  Email:"+ invoice.getEmail()));
        slackClient.sendMessage(String.format("Invoice  FAX:"+ invoice.getFax()));
        slackClient.sendMessage(String.format("Invoice  WEBSITE:"+ invoice.getWebsite()));
        return invoice;
    }

    @RequestMapping(value = "Invoice/getByEmail", method = RequestMethod.GET)
    public Invoice getInvoiceByEmail(@RequestParam String email) {
        Invoice invoice = invoiceService.getInvoiceByEmail(email);
        return invoice;
    }

    @RequestMapping(value = "Invoice/getByFax", method = RequestMethod.GET)
    public Invoice getInvoiceByFax(@RequestParam String fax) {
        Invoice invoice = invoiceService.getInvoiceByFax(fax);
        return invoice;
    }

    @RequestMapping(value = "Invoice/getByWebsite", method = RequestMethod.GET)
    public Invoice getInvoiceByWebsite(@RequestParam String website) {
        Invoice invoice = invoiceService.getInvoiceByWebsite(website);
        return invoice;
    }

    @GetMapping(value = "addInvoice")
    public void addInvoice() {
        invoiceService.addInvoice();
        invoiceService.addInvoice();
    }

    @RequestMapping(value = "getIsActive", method = RequestMethod.GET)
    public List<Invoice> getAllActiveInvoices() {
        List<Invoice> invoices = invoiceService.getAllActiveInvoices();
        for (Invoice invoice : invoices) {
            slackClient.sendMessage(String.format("Invoice  IS ACTIVE:"+ invoice.getIsActive()));
            slackClient.sendMessage(String.format("Invoice  ID:"+ invoice.getId()));
            slackClient.sendMessage(String.format("Invoice  Email:"+ invoice.getEmail()));
            slackClient.sendMessage(String.format("Invoice  FAX:"+ invoice.getFax()));
            slackClient.sendMessage(String.format("Invoice  WEBSITE:"+ invoice.getWebsite()));
            slackClient.sendMessage(String.format("-----------------------------------"));


        }
        return invoices;
    }

    @RequestMapping(value = "/getInActive", method = RequestMethod.GET)
    public List<Invoice> getAllInActiveInvoices() {
        List<Invoice> invoces = invoiceService.getAllInActiveInvoices();
        return invoces;
    }

    @RequestMapping(value = "/getLatestRow", method = RequestMethod.GET)
    public Invoice findTopByOrderById() {
        Invoice invoice = invoiceService.findTopByOrderById();
        slackClient.sendMessage(String.format("Invoice  IS ACTIVE:"+ invoice.getIsActive()));
        slackClient.sendMessage(String.format("Invoice  ID:"+ invoice.getId()));
        slackClient.sendMessage(String.format("Invoice  Email:"+ invoice.getEmail()));
        slackClient.sendMessage(String.format("Invoice  FAX:"+ invoice.getFax()));
        slackClient.sendMessage(String.format("Invoice  WEBSITE:"+ invoice.getWebsite()));
        slackClient.sendMessage(String.format("-----------------------------------"));

        return invoice;
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public void deleteByIdIsActive(Integer id) {
        invoiceService.deleteByIdIsActive(id);
    }

    @RequestMapping(value = "/deleteBySetActiveFalse", method = RequestMethod.GET)
    public void deleteItemByID(Integer id) {
        invoiceService.deleteInvoiceByID(id);
    }

    @RequestMapping(value = "/deleteByEmail", method = RequestMethod.GET)
    public void deleteByInvoiceEmail(String email) {
        invoiceService.deleteInvoiceByEmail(email);
    }

    @RequestMapping(value = "deleteAllInvoices", method = RequestMethod.GET)
    public void deleteAllInvoices() {
       invoiceService.deleteAllInvoices();
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        invoiceService.deleteAll();
    }

    @RequestMapping(value = "/createInvoice", method = RequestMethod.POST)
    public void createInvoice(@RequestBody InvoiceRequest invoiceRequest) throws ParseException {
        invoiceService.createInvoice(invoiceRequest.getEmail(), invoiceRequest.getFax(), invoiceRequest.getWebsite(), invoiceRequest.getCustomerId(), invoiceRequest.getCreatedDate(), invoiceRequest.getIsActive());


    }

    @GetMapping(value = "deleteCustomerByInvoiceId")
    public void  deleteInvoiceByCustomerId(@RequestParam Integer id) {
        invoiceService. deleteInvoiceByCustomerId(id);

    }

    @RequestMapping(value="deleteByUpdatedDate", method = RequestMethod.GET)
    public String deleteByUpdatedDate(@RequestParam("updatedDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date updatedDate) {

        try {
            invoiceService.deleteByUpdatedDate(updatedDate);
            slackClient.sendMessage(String.format("Successfully deleted invoices Updated on %s", updatedDate.toString()));
            return "Invoices deleted successfully";
        } catch (Exception e) {
            slackClient.sendMessage(String.format("Error deleting invoices Updated on %s: %s", updatedDate.toString(), e.getMessage()));
            return "Error deleting invoices";
        }
    }

    @RequestMapping(value="/deleteByCreatedDate", method = RequestMethod.GET)
    public String deleteByCreatedDate(@RequestParam("createdDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date createdDate) {
        try {
            invoiceService.deleteByCreatedDate(createdDate);
            slackClient.sendMessage(String.format("Successfully deleted invoices created on %s", createdDate.toString()));
            return "Invoices deleted successfully";
        } catch (Exception e) {
            slackClient.sendMessage(String.format("Error deleting invoices created on %s: %s", createdDate.toString(), e.getMessage()));
            return "Error deleting invoices";
        }
    }

    @RequestMapping(value="/deleteByCreatedAfterDate", method = RequestMethod.GET)
    public String deleteByAfterCreatedDate(@RequestParam("date") Date date) {
        invoiceService.deleteByCreatedAfterDate(date);
        slackClient.sendMessage(String.format("Update invoices by created after  date %s", date.toString()));
        return "Update invoices by created after  date";

    }


    @RequestMapping(value = "/getByUpdatedDate", method = RequestMethod.GET)
    public Invoice getInvoiceByUpdatedDate(Date updatedDate){
        Invoice invoice = invoiceService.getInvoiceByUpdatedDate(updatedDate);
        return invoice;
    }

}
