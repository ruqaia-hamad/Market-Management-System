package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import com.TechM.springDemoProject.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    CustomerRepository customerRepository;

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
        List<Invoice> invoices = invoiceRepository.findAllActive();
        return invoices;
    }


    public List<Invoice> getAllInActiveInvoices() {
        List<Invoice> invoices = invoiceRepository.findAllInActive();
        return invoices;
    }

    public Invoice findTopByOrderById() {
        Invoice invoice = invoiceRepository.findTopByOrderById();
        return invoice;

    }


    public void deleteByIdIsActive(Integer id) {
        invoiceRepository.deleteByIdIsActive(id);

    }



    public void deleteAll(){
        invoiceRepository.deleteAll();
    }


    public void createInvoice(  String email,String fax,String website, Integer customerId,String createdDate,Boolean isActive) throws ParseException {
        Invoice invoice=new Invoice();
        invoice.setEmail(email);
        invoice.setFax(fax);
        Customer customer=customerRepository.getCustomerById(customerId);
        invoice.setCustomer(customer);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convetedDate = formatter.parse(createdDate);
        invoice.setCreatedDate(convetedDate);
        invoice.setIsActive(isActive);
        invoiceRepository.save(invoice);
    }

    public void deleteInvoiceByID(Integer id) {
        Invoice invoice=invoiceRepository.getInvoiceById(id);
        invoice.setIsActive(false);
        invoiceRepository.save(invoice);
    }

    public void deleteInvoiceByEmail(String email) {
        Invoice invoice=invoiceRepository.getInvoiceByEmail(email);
        invoice.setIsActive(false);
        invoiceRepository.save(invoice);
    }

    public void deleteAllInvoices() {
     Iterable<Invoice> invoices= invoiceRepository.findAll();
        for (Invoice invoice: invoices) {
            invoice.setIsActive(false);

        }
        invoiceRepository.saveAll(invoices);
    }

    public void  deleteInvoiceByCustomerId(Integer id) {
        Iterable<Invoice> invoices= invoiceRepository.findByCustomerId(id);
        for (Invoice invoice: invoices) {
            invoice.setIsActive(false);

        }
        invoiceRepository.saveAll(invoices);
    }


    public void deleteByCreatedDate(Date createdDate){
        Iterable<Invoice> invoices = invoiceRepository.findByCreatedDate(createdDate);
        for (Invoice invoice: invoices) {
            invoice.setIsActive(false);

        }
        invoiceRepository.saveAll(invoices);

    }

    public void deleteByUpdatedDate(Date updatedDate){
        Iterable<Invoice> invoices = invoiceRepository.findByUpdatedDate(updatedDate);
        for (Invoice invoice: invoices) {
            invoice.setIsActive(false);

        }
        invoiceRepository.saveAll(invoices);

    }

    public void deleteByCreatedAfterDate(Date date) {
        Iterable<Invoice> invoices = invoiceRepository.findByCreatedDateAfter(date);
        for (Invoice invoice: invoices) {
            invoice.setIsActive(false);

        }
        invoiceRepository.saveAll(invoices);


    }
}

