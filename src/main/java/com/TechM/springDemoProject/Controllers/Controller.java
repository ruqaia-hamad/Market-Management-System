package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Services.CustomerService;
import com.TechM.springDemoProject.Services.InvoiceService;
import com.TechM.springDemoProject.Services.ItemService;
import com.TechM.springDemoProject.Services.MarketService;
import com.TechM.springDemoProject.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Controller")

public class Controller {

    @Autowired
    CustomerService customerService;
    @Autowired
    MarketService marketService;

    @Autowired
    ItemService itemService;

    @Autowired
    InvoiceService invoiceService;


    @Autowired
    SlackClient slackClient;

    //creating API

    @RequestMapping(value = "getByMarket", method = RequestMethod.GET)
    public List<Customer> getCustomerByMarketId1(@RequestParam Integer Market_Id) {
        List<Customer> customers = customerService.getCustomerByMarketId1(Market_Id);
        for (Customer customer : customers) {
            Integer customerId=customer.getId();
            String firstName=customer.getCustomerFirstName();
            String secondName=customer.getCustomerSecondName();
            String contact=customer.getContact();
            Date createdDate = customer.getCreatedDate();
            Date updatedDate = customer.getUpdatedDate();
            boolean isActive = customer.getIsActive();
            slackClient.sendMessage(String.format("Customer details : customerId=%s , firstName=%s , secondName=%s ,contact=%s ,createdDate=%s , updatedDate=%s , isActive=%s",customerId,firstName,secondName,contact, createdDate, updatedDate, isActive));
        }

        return customers;

    }

    @RequestMapping(value = "Customer/getByMarketId", method = RequestMethod.GET)
    public List<CustomerMarketDTO> getCustomerByMarketId(@RequestParam Integer Market_Id) {
        List<CustomerMarketDTO> customers = customerService.getCustomerByMarketId(Market_Id);
        return customers;


    }


    @GetMapping
    public String helloStudent() {
        return "Hello Student";
    }
//    @GetMapping(value = "test")
//    public String test(){
//        return "${spring.profiles.active"};
//    }


    @GetMapping(value = "slackMessage")
    public void message(@RequestParam String text){
        slackClient.sendMessage(text);
    }
}
