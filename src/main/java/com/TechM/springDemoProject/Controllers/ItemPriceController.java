package com.TechM.springDemoProject.Controllers;


import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.ItemPrice;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import com.TechM.springDemoProject.RequestObject.CustomerRequestForCreateCustomer;
import com.TechM.springDemoProject.Services.ItemPriceService;
import com.TechM.springDemoProject.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController

@RequestMapping(value = "ItemPrice")
public class ItemPriceController {

    @Autowired
    ItemPriceService itemPriceService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SlackClient slackClient;


    @RequestMapping(value = "/addToItemPrice", method = RequestMethod.POST)
    public void addToItemPrice(@RequestBody ItemPrice itemPrice) throws ParseException {

        if (itemPrice.getCustomerRefId() > 0) {
            itemPrice.setCustomer(customerRepository.getCustomerById(itemPrice.getCustomerRefId()));
            itemPriceService.createItemPrice(itemPrice);
            // itemPriceService.addToItemPrice(itemPrice.getPriceId(), itemPrice.getDatePaid(), itemPrice.getCreatedDate(), itemPrice.getIsActive(), itemPrice.getCustomer().getId());
        }
    }


}
