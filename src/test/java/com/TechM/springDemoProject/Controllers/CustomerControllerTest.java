package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.RequestObject.CustomerRequestForCreateCustomer;
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
    void getCustomerByIdReturnsNullForNonexistentId() throws Exception {
        assertNull(customerController.getCustomerById(100));
    }

    @Test
    void getCustomerByIdReturnsNullForNonexistentId1() throws Exception {
        assertNull(customerController.getCustomerById(80));
    }
    @Test
    void getCustomerByIdReturnsNullForNonexistentId2() throws Exception {
        assertNull(customerController.getCustomerById(79));
    }    @Test
    void getCustomerByIdReturnsNullForNonexistentId3() throws Exception {
        assertNull(customerController.getCustomerById(50));
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


    @Test
    void setIsActiveFalseByMarketId2() throws Exception {
        Integer marketId = 5;
        String result = customerController.setIsActiveFalseByMarketId(marketId);
        assertEquals("Record updated", result);
    }

    @Test
    void setIsActiveFalseByMarketId3() throws Exception {
        Integer marketId = 4;
        String result = customerController.setIsActiveFalseByMarketId(marketId);
        assertEquals("Record updated", result);
    }



    @Test
    void testDeleteAllCustomers1() throws Exception {
        String message = customerController.deleteAllCustomers();
        assertEquals("ALL Customer isActive=false", message);
        List<Customer> customers = customerController.getAllCustomers();
        for (Customer customer : customers) {
            assertFalse(customer.getIsActive());
        }
    }

    @Test
    void testDeleteAllCustomers3() throws Exception {

        String result = customerController.deleteAllCustomers();

        assertEquals("ALL Customer isActive=false", result);
    }
    @Test
    void testDeleteAllCustomers4() throws Exception {

        customerController.deleteAllCustomers();

        List<Customer> activeCustomers = customerController.getAllActiveCustomers();
        assertTrue(activeCustomers.isEmpty());
    }


    @Test
    void testFindTopByOrderByUpdated2() {
        List<Customer> customers = customerController.findTopByOrderByUpdated();
        for (Customer customer : customers) {
            assertNotNull(customer.getUpdatedDate());
        }
    }

    @Test
    void testFindTopByOrderByUpdated1() {
        List<Customer> customers = customerController.findTopByOrderByUpdated();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
    }


}