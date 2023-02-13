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
public class Controller {

    @Autowired
    CustomerService customerService;
    @Autowired
    MarketService marketService;

    @Autowired
    ItemService itemService;

    @Autowired
    InvoiceService invoiceService;

    //creating API
    @RequestMapping(value = "Market/getAll", method= RequestMethod.GET)
    public List<Market> getAllMarkets(){
        List<Market> markets=marketService.getAllMarkets();
        return markets;
    }

    @RequestMapping(value = "Customer/getAll", method= RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        List<Customer> customers=customerService.getAllCustomers();
        return customers;
    }
    @RequestMapping(value = "Item/getAll", method= RequestMethod.GET)
    public List<Item>  getAllItems(){
        List<Item> items=itemService.getAllItems();
        return items;
    }
    @RequestMapping(value = "Invoice/getAll", method= RequestMethod.GET)
    public List<Invoice> getAllInvoices(){
        List<Invoice> invoices=invoiceService.getAllInvoices();
        return invoices;
    }

    @RequestMapping(value = "Market/getById", method = RequestMethod.GET)
    public Market getMarketById(@RequestParam Integer marketId){
        Market market=marketService.getMarketById(marketId);
        return market;
    }

    @RequestMapping(value = "Invoice/getById", method = RequestMethod.GET)
    public Invoice getInvoiceById(@RequestParam Integer invoiceId){
        Invoice invoice=invoiceService.getInvoiceById(invoiceId);
        return invoice;
    }

    @RequestMapping(value = "Invoice/getByEmail", method = RequestMethod.GET)
    public Invoice getInvoiceByEmail(@RequestParam String email){
        Invoice invoice=invoiceService.getInvoiceByEmail(email);
        return invoice;
    }

    @RequestMapping(value = "Invoice/getByFax", method = RequestMethod.GET)
    public Invoice getInvoiceByFax(@RequestParam String fax){
        Invoice invoice=invoiceService.getInvoiceByFax(fax);
        return invoice;
    }

    @RequestMapping(value = "Invoice/getByWebsite", method = RequestMethod.GET)
    public Invoice getInvoiceByWebsite(@RequestParam String website){
        Invoice invoice=invoiceService.getInvoiceByWebsite(website);
        return invoice;
    }



    @RequestMapping(value = "Item/getById", method = RequestMethod.GET)
    public Item getItemById(@RequestParam Integer itemId){
        Item item=itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping(value = "Item/getByPrice", method = RequestMethod.GET)
    public Item getItemByPrice(@RequestParam Integer price){
        Item item=itemService.getItemByPrice(price);
        return item;
    }

    @RequestMapping(value = "Item/getByName", method = RequestMethod.GET)
    public Item getItemByName(@RequestParam String name){
        Item item=itemService.getItemByName(name);
        return item;
    }

    @RequestMapping(value = "Customer/getById", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer customerId){
        Customer customer=customerService.getCustomerById(customerId);
        return customer;
    }

    @RequestMapping(value = "Customer/getByFirstName", method = RequestMethod.GET)
    public Customer getCustomerByFirstName(@RequestParam String customerFirstName){
        Customer customer=customerService.getCustomerByFirstName(customerFirstName);
        return customer;
    }

    @RequestMapping(value = "Customer/getBySecondName", method = RequestMethod.GET)
    public Customer getCustomerBySecondName(@RequestParam String customerSecondName){
        Customer customer=customerService.getCustomerBySecondName(customerSecondName);
        return customer;
    }

    @RequestMapping(value = "Customer/getByContact", method = RequestMethod.GET)
    public Customer getCustomerByContact(@RequestParam String contact){
        Customer customer=customerService.getCustomerByContact(contact);
        return customer;
    }

    @RequestMapping(value = "Market/getByName", method = RequestMethod.GET)
    public Market getMarketByName(@RequestParam String name){
        Market market=marketService.getMarketByName(name);
        return market;
    }


    @RequestMapping(value = "Customer/getByMarketId", method = RequestMethod.GET)
    public List<CustomerMarketDTO> getCustomerByMarketId(@RequestParam Integer Market_Id){
        List<CustomerMarketDTO> customers= customerService.getCustomerByMarketId(Market_Id);
        return customers;

    }
    @GetMapping(value = "addCustomer")
    public void addCustomer(){
        customerService.addCustomer();
        customerService.addCustomer();
    }

    @GetMapping(value = "addMarket")
    public void addMarket(){
        marketService.addMarket();

    }

    @GetMapping(value = "addInvoice")
        public void addInvoice(){
        invoiceService.addInvoice();
        invoiceService.addInvoice();
        }

        @GetMapping(value = "addItem")
        public void addItem(){
        itemService.addItem();
        itemService.addItem();
        }

    @GetMapping(value = "deleteById")
    public String deleteCutomerById(@RequestParam Integer id){
     customerService.deleteCustomerById(id);
     return "Recored delete";
    }
    @GetMapping
    public String helloStudent(){
        return "Hello Student";
    }

}
