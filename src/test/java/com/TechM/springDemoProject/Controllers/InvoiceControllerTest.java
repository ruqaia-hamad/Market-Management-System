package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceControllerTest {

    @Autowired
    InvoiceController invoiceController;
    @Test
    void getInvoiceById() {
        String email = invoiceController.getInvoiceById(1).getEmail();
        assertEquals("ahmed@gmail.com", email);
    }


    @Test
    void getInvoiceByIdReturnsInvoiceWithCorrectId() throws Exception {
        Invoice invoice = invoiceController.getInvoiceById(1);
        assertNotNull(invoice);
        assertEquals(1, invoice.getId());
    }

    @Test
    void getAllInvoices() throws Exception {
        List<Invoice> invoices = invoiceController.getAllInvoices();
        assertFalse(invoices.isEmpty());
        for (Invoice invoice : invoices) {
            assertNotNull(invoice.getEmail());
            assertNotNull(invoice.getFax());
            assertNotNull(invoice.getWebsite());
            assertNotNull(invoice.getIsActive());
            assertNotNull(invoice.getCreatedDate());
            assertNotNull(invoice.getUpdatedDate());
        }

    }

    @Test
    void testGetAllItemsReturnsCorrectNumberOfItems() {
        List<Invoice> invoices = invoiceController.getAllInvoices();
        assertEquals(2, invoices.size());
    }


    @Test
    void testGetAllActiveInvoiceReturnsOnlyActiveInvoices() {
        List<Invoice> activeInvoices= invoiceController.getAllActiveInvoices();
        for (Invoice invoice : activeInvoices) {
            assertTrue(invoice.getIsActive());
        }
    }


    @Test
    void testGetAllActiveItemsReturnsCorrectNumberOfInvoice() {
        List<Invoice> activeInvoices = invoiceController.getAllActiveInvoices();
        int expectedCount = 2;
        assertEquals(expectedCount, activeInvoices.size());
    }

}

