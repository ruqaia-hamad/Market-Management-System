package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Executable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {
    @Autowired
    CustomerController customerController;

    @Test
    void getAllCustomers() {
        List<Customer> customers = customerController.getAllCustomers();
        assertFalse(customers.isEmpty());
        for (Customer customer : customers) {
            assertNotNull(customer.getCustomerFirstName());
            assertNotNull(customer.getCustomerSecondName());
            assertNotNull(customer.getContact());
            assertNotNull(customer.getIsActive());
            assertNotNull(customer.getCreatedDate());
        }

    }

    @Test
    void getCustomerById() throws Exception{
        Customer customer = customerController.getCustomerById(1);
        assertEquals("Ahmed", customer.getCustomerFirstName());
    }

    @Test
    void getCustomerById2() throws Exception{
        Customer customer = customerController.getCustomerById(2);
        assertEquals("Ahmed", customer.getCustomerFirstName());
    }
    @Test
    void getCustomerByIdThrowsErrorForInvalidId() throws Exception{
        assertThrows(Exception.class, () -> customerController.getCustomerById(0));
    }


    @Test
    void getCustomerByIdReturnsNullForNonexistentId() throws Exception {
        assertNull(customerController.getCustomerById(100));
    }


    @Test
    void testGetAllCustomers() throws Exception {
        List<Customer> customers = customerController.getAllCustomers();
        assertFalse(customers.isEmpty());
    }
    @Test
    void testGetAllCustomers2() throws Exception {
        List<Customer> customers = customerController.getAllCustomers();
        assertNotNull(customers);
    }



    @Test
    void setIsActiveFalseByMarketId() throws Exception {
        Integer marketId = 2;
        String result = customerController.setIsActiveFalseByMarketId(marketId);
        assertEquals("Record updated", result);
    }


}