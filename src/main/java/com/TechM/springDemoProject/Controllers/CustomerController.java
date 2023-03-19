package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import com.TechM.springDemoProject.RequestObject.CustomerRequest;
import com.TechM.springDemoProject.RequestObject.CustomerRequestForCreateCustomer;
import com.TechM.springDemoProject.Services.CustomerService;
import com.TechM.springDemoProject.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @Autowired
    SlackClient slackClient;


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        Integer customerID= customer.getId();
        String firstName=customer.getCustomerFirstName();
        String secondName=customer.getCustomerSecondName();
        String contact=customer.getContact();
        Date createdDate = customer.getCreatedDate();
        Date updatedDate = customer.getUpdatedDate();
        boolean isActive = customer.getIsActive();
        slackClient.sendMessage(String.format("Customer details : customerId=%s , firstName=%s , secondName=%s ,contact=%s ,createdDate=%s , updatedDate=%s , isActive=%s",customerID,firstName,secondName,contact, createdDate, updatedDate, isActive));
        return customer;
    }

    @RequestMapping(value = "getByFirstName", method = RequestMethod.GET)
    public Customer getCustomerByFirstName(@RequestParam String customerFirstName) {
        Customer customer = customerService.getCustomerByFirstName(customerFirstName);
        String message = "Customer Information for " + customerFirstName + ": \n" +
                "Name: " + customer.getCustomerFirstName() + " " + customer.getCustomerSecondName() + "\n" +
                "Contact: " + customer.getContact() + "\n" +
                "Created date: " + customer.getCreatedDate() + "\n" +
                "Updated Date: " + customer.getUpdatedDate() + "\n";

        slackClient.sendMessage(message);
        return customer;
    }

    @RequestMapping(value = "getBySecondName", method = RequestMethod.GET)
    public Customer getCustomerBySecondName(@RequestParam String customerSecondName) {
        Customer customer = customerService.getCustomerBySecondName(customerSecondName);
        String message = "Customer Information for " + customerSecondName + ": \n" +
                "Name: " + customer.getCustomerFirstName() + " " + customer.getCustomerSecondName() + "\n" +
                "Contact: " + customer.getContact() + "\n" +
                "Created date: " + customer.getCreatedDate() + "\n" +
                "Updated Date: " + customer.getUpdatedDate() + "\n";

        slackClient.sendMessage(message);
        return customer;

    }

    @RequestMapping(value = "getByContact", method = RequestMethod.GET)
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
        slackClient.sendMessage("Customer record with ID " + id + " has been deleted.");
        return "Recored delete";
    }

    @GetMapping(value = "deleteCustomerByMarketId")
    public String deleteCustomerByMarketId(@RequestParam Integer id) {
        customerService.deleteCustomerByMarketId(id);
        slackClient.sendMessage("Customer record with Market_ID " + id + " has been deleted.");
          return "Recored delete";
    }


    @RequestMapping(value = "getIsActive", method = RequestMethod.GET)
    public List<Customer> getAllActiveCustomers() {
        List<Customer> customers = customerService.getAllActiveCustomers();
        for (Customer customer : customers) {
            Integer customerId=customer.getId();
            String firstName=customer.getCustomerFirstName();
            String secondName=customer.getCustomerSecondName();
            String contact=customer.getContact();
            Date createdDate = customer.getCreatedDate();
            Date updatedDate = customer.getUpdatedDate();
            boolean isActive = customer.getIsActive();
            slackClient.sendMessage(String.format(" Active Customer details  : customerId=%s , firstName=%s , secondName=%s ,contact=%s ,createdDate=%s , updatedDate=%s , isActive=%s",customerId,firstName,secondName,contact, createdDate, updatedDate, isActive));
        }
        return customers;
    }

    @RequestMapping(value = "getInActive", method = RequestMethod.GET)
    public List<Customer> getAllInActiveCustomers() {
        List<Customer> customers = customerService.getAllInActiveCustomers();
        for (Customer customer : customers) {
            Integer customerId=customer.getId();
            String firstName=customer.getCustomerFirstName();
            String secondName=customer.getCustomerSecondName();
            String contact=customer.getContact();
            Date createdDate = customer.getCreatedDate();
            Date updatedDate = customer.getUpdatedDate();
            boolean isActive = customer.getIsActive();
            slackClient.sendMessage(String.format("  Customer details where isActive=false : customerId=%s , firstName=%s , secondName=%s ,contact=%s ,createdDate=%s , updatedDate=%s , isActive=%s",customerId,firstName,secondName,contact, createdDate, updatedDate, isActive));
        }

        return customers;
    }


    @RequestMapping(value = "deleteAllCustomers", method = RequestMethod.GET)
    public String deleteAllCustomers() {
        customerService.deleteAllCustomers();
        slackClient.sendMessage("ALL Customer isActive=false");
        return "ALL Customer isActive=false";
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public List<Customer> findTopByOrderByUpdated() {
        List<Customer> customers = customerService.findTopByOrderByUpdated();
        for (Customer customer : customers) {
            Integer customerId=customer.getId();
            String firstName=customer.getCustomerFirstName();
            String secondName=customer.getCustomerSecondName();
            String contact=customer.getContact();
            Date createdDate = customer.getCreatedDate();
            Date updatedDate = customer.getUpdatedDate();
            boolean isActive = customer.getIsActive();
            slackClient.sendMessage(String.format("  Customer details =false : customerId=%s , firstName=%s , secondName=%s ,contact=%s ,createdDate=%s , updatedDate=%s , isActive=%s",customerId,firstName,secondName,contact, createdDate, updatedDate, isActive));
        }
        return customers;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteByIdIsActive(Integer id) {
        customerService.deleteByIdIsActive(id);
        slackClient.sendMessage("customer with Id :"+id +"isActive=0");
        return "Record Updated";

    }


    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Customer findTopByOrderById() {
        Customer customer = customerService.findTopByOrderById();

            Integer customerId=customer.getId();
            String firstName=customer.getCustomerFirstName();
            String secondName=customer.getCustomerSecondName();
            String contact=customer.getContact();
            Date createdDate = customer.getCreatedDate();
            Date updatedDate = customer.getUpdatedDate();
            boolean isActive = customer.getIsActive();
            slackClient.sendMessage(String.format(" Get Latest Row : customerId=%s , firstName=%s , secondName=%s ,contact=%s ,createdDate=%s , updatedDate=%s , isActive=%s",customerId,firstName,secondName,contact, createdDate, updatedDate, isActive));

        return customer;
    }

    @RequestMapping(value = "/getByCreatedDate", method = RequestMethod.GET)
    public Customer getCustomerByCreatedDate(Date createdDate){
        Customer customer = customerService.getCustomerByCreatedDate(createdDate);
        return customer;
    }

    @RequestMapping(value = "/getByUpdatedDate", method = RequestMethod.GET)
    public Customer getCustomerByUpdatedDate(Date updatedDate){
        Customer customer = customerService.getCustomerByUpdatedDate(updatedDate);
        return customer;
    }

    @RequestMapping(value = "/deleteBYId", method = RequestMethod.GET)
    public void deleteCustomerByID(Integer id) {
        customerService.deleteCustomerByID(id);
    }


    @RequestMapping(value = "/deleteByFirstName", method = RequestMethod.GET)
    public void deleteByCustomerFirstName(String customerFirstName) {
        customerService.deleteCustomersByFirstName(customerFirstName);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        customerService.deleteAll();
    }


    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public String createCustomer(@RequestBody CustomerRequestForCreateCustomer customerRequest) throws ParseException {
        try {
            customerService.createCustomer(customerRequest.getFirstName(), customerRequest.getSecondName(), customerRequest.getContact(), customerRequest.getCreatedDate(), customerRequest.getIsActive(), customerRequest.getMarketId());
            slackClient.sendMessage(" new customer  added Successfully ");
            return " new customer  added Successfully ";
        } catch (Exception e) {
            slackClient.sendMessage(" adding new customer failed");
            return "adding new customer failed";
        }

    }


    @RequestMapping(value = "/deleteByUpdatedDate", method = RequestMethod.GET)
    public void deleteCustomerByUpdatedDate(@RequestParam("updatedDate") Date updatedDate) {
        customerService.deleteCustomerByUpdatedDate(updatedDate);
    }

    @RequestMapping(value = "/deleteByCreatedDate", method = RequestMethod.GET)
    public void deleteByCreatedDate(@RequestParam("createdDate") Date createdDate) {
        customerService.deleteCustomerByCreatedDate(createdDate);
    }

    @RequestMapping(value = "/deleteByCreatedAfterDate", method = RequestMethod.GET)
    public void deleteByAfterCreatedDate(@RequestParam("date") Date date) {
        customerService.deleteByCreatedAfterDate(date);
    }

}



