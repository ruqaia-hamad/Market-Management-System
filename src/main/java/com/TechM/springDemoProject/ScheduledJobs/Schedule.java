package com.TechM.springDemoProject.ScheduledJobs;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Services.CustomerService;
import com.TechM.springDemoProject.Services.InvoiceService;
import com.TechM.springDemoProject.Services.ItemService;
import com.TechM.springDemoProject.Services.MarketService;
import com.TechM.springDemoProject.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Component
public class Schedule {
    @Autowired
    SlackClient slackClient;

    @Autowired
    ItemService itemService;


    @Autowired
    CustomerService customerService;

    @Autowired
    MarketService marketService;

    @Autowired
    InvoiceService invoiceService;


    @Scheduled(cron = "* 15 * * * *")
    @RequestMapping(value = "getAllItem")
    public List<Item> getAllItems() {
        List<Item> items = itemService.getAllItems();
        for (Item item : items) {
            slackClient.sendMessage(String.format("Item name:" + item.getName()));
            slackClient.sendMessage(String.format("Item  Price:" + item.getPrice()));
            slackClient.sendMessage(String.format("Item  Is Active:" + item.getIsActive()));
            slackClient.sendMessage(String.format("Item Created Date::" + item.getCreatedDate()));
            slackClient.sendMessage(String.format("Item Updated Date:" + item.getUpdatedDate()));
            slackClient.sendMessage(String.format("-----------------------------------"));


        }
        return items;
    }


    @Scheduled(cron = "* 5 * * * *")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            slackClient.sendMessage(String.format("Customer first name:" + customer.getCustomerFirstName()));
            slackClient.sendMessage(String.format("Customer Second name:" + customer.getCustomerSecondName()));
            slackClient.sendMessage(String.format("Contact:" + customer.getContact()));
            slackClient.sendMessage(String.format("Created Date::" + customer.getCreatedDate()));
            slackClient.sendMessage(String.format("Updated Date:" + customer.getUpdatedDate()));
            slackClient.sendMessage(String.format("-----------------------------------"));


        }
        return customers;
    }


    @Scheduled(cron = "* 2 * * * *")

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        for (Invoice invoice : invoices) {
            slackClient.sendMessage(String.format("Invoice  ID:" + invoice.getId()));
            slackClient.sendMessage(String.format("Invoice  Email:" + invoice.getEmail()));
            slackClient.sendMessage(String.format("Invoice  FAX:" + invoice.getFax()));
            slackClient.sendMessage(String.format("Invoice  WEBSITE:" + invoice.getWebsite()));
            slackClient.sendMessage(String.format("-----------------------------------"));


        }
        return invoices;
    }


    @Scheduled(cron = "* 4 * * * *")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Market> getAllMarkets() {
        List<Market> markets = marketService.getAllMarkets();
        for (Market market : markets) {

            slackClient.sendMessage("Marker Name " + market.getName());
            slackClient.sendMessage("Marker ID " + market.getId());
            slackClient.sendMessage("Marker Created Date " + market.getCreatedDate());
            slackClient.sendMessage("Marker Updated Date " + market.getUpdatedDate());
        }
        return markets;
    }
}
