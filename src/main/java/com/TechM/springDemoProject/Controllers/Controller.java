package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Controllers.DTO.MarketCustomerDTO;
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

//    @Autowired
//    CustomerService customerService;
    @Autowired
    MarketService marketService;

    @Autowired
    ItemService itemService;

    @Autowired
    InvoiceService invoiceService;


    @Autowired
    SlackClient slackClient;

    //creating API






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
