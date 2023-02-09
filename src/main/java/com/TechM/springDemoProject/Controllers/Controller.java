package com.TechM.springDemoProject.Controllers;


import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Services.CustomerService;
import com.TechM.springDemoProject.Services.InvoiceService;
import com.TechM.springDemoProject.Services.ItemService;
import com.TechM.springDemoProject.Services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
