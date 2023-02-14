package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;


    public void addInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setEmail("invoice@invoice.com");
        invoice.setFax("423536");
        invoice.setWebsite("www.grh.com");

    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.getAllInvoices();
    }

    public Invoice getInvoiceById(Integer id) {
        Invoice invoice = invoiceRepository.getInvoiceById(id);
        return invoice;
    }

    public Invoice getInvoiceByEmail(String email) {
        Invoice invoice = invoiceRepository.getInvoiceByEmail(email);
        return invoice;
    }

    public Invoice getInvoiceByFax(String fax) {
        Invoice invoice = invoiceRepository.getInvoiceByFax(fax);
        return invoice;
    }


    public Invoice getInvoiceByWebsite(String website) {
        Invoice invoice = invoiceRepository.getInvoiceByWebsite(website);
        return invoice;
    }


    public List<Invoice> getAllActiveInvoices() {
        List<Invoice>  invoices= invoiceRepository.findAllActive();
        return invoices;
    }
}

