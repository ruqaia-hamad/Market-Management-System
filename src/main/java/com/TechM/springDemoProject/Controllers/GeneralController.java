package com.TechM.springDemoProject.Controllers;


import com.TechM.springDemoProject.Models.*;
import com.TechM.springDemoProject.Services.CustomerService;
import com.TechM.springDemoProject.Services.InvoiceService;
import com.TechM.springDemoProject.Services.ItemService;
import com.TechM.springDemoProject.Services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    CustomerService customerService;
    @Autowired
    MarketService marketService;

    @Autowired
    ItemService itemService;

    @Autowired
    InvoiceService invoiceService;

    //creating API

    @RequestMapping(value = "Customer/getByMarket", method = RequestMethod.GET)
    public List<Customer> getCustomerByMarketId1(@RequestParam Integer Market_Id) {
        List<Customer> customers = customerService.getCustomerByMarketId1(Market_Id);
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

}
