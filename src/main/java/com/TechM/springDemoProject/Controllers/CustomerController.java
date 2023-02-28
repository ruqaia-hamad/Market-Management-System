package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.RequestObject.CustomerRequest;
import com.TechM.springDemoProject.RequestObject.CustomerRequestForCreateCustomer;
import com.TechM.springDemoProject.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "Customer/getAll", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    @RequestMapping(value = "Customer/getById", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return customer;
    }

    @RequestMapping(value = "Customer/getByFirstName", method = RequestMethod.GET)
    public Customer getCustomerByFirstName(@RequestParam String customerFirstName) {
        Customer customer = customerService.getCustomerByFirstName(customerFirstName);
        return customer;
    }

    @RequestMapping(value = "Customer/getBySecondName", method = RequestMethod.GET)
    public Customer getCustomerBySecondName(@RequestParam String customerSecondName) {
        Customer customer = customerService.getCustomerBySecondName(customerSecondName);
        return customer;
    }

    @RequestMapping(value = "Customer/getByContact", method = RequestMethod.GET)
    public Customer getCustomerByContact(@RequestParam String contact) {
        Customer customer = customerService.getCustomerByContact(contact);
        return customer;
    }

    @GetMapping(value = "addCustomer")
    public void addCustomer() {
        customerService.addCustomer();
        customerService.addCustomer();
    }

    @GetMapping(value = "deleteById")
    public String deleteCutomerById(@RequestParam Integer id) {
        customerService.deleteCustomerById(id);
        return "Recored delete";
    }


    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<Customer> getAllActiveCustomers() {
        List<Customer> customers = customerService.getAllActiveCustomers();
        return customers;
    }

    @RequestMapping(value = "/getInActive", method = RequestMethod.GET)
    public List<Customer> getAllInActiveCustomers() {
        List<Customer> customers = customerService.getAllInActiveCustomers();
        return customers;
    }



    @RequestMapping(value = "/getLatestUpdated", method = RequestMethod.GET)
    public List<Customer> findTopByOrderByUpdated() {
        List<Customer> customer = customerService.findTopByOrderByUpdated();
        return customer;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteByIdIsActive(Integer id) {
      customerService.deleteByIdIsActive(id);
    }


    @RequestMapping(value = "/deleteByFirstName", method = RequestMethod.GET)
    public void deleteByCustomerFirstName(String  customerFirstName) {
        customerService.deleteCustomersByFirstName(customerFirstName);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        customerService.deleteAll();
    }


    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public void createCustomer(@RequestBody CustomerRequestForCreateCustomer customerRequest) throws ParseException {
        customerService.createCustomer(customerRequest.getFirstName(),customerRequest.getSecondName(),customerRequest.getContact());


}}



