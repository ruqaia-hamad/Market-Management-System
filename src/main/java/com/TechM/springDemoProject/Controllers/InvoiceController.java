package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "Invoice/getAll", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return invoices;
    }


    @RequestMapping(value = "Invoice/getById", method = RequestMethod.GET)
    public Invoice getInvoiceById(@RequestParam Integer invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
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
}
