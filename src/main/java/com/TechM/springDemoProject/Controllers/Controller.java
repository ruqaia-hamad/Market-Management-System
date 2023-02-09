package com.TechM.springDemoProject.Controllers;


import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    CustomerService customerService;

    //creating API
    @RequestMapping(value = "Market/getAll", method= RequestMethod.GET)
    public List<Market> getAllMarkets(){
        List<Market> markets=new ArrayList<>();
        return markets;
    }



    @GetMapping(value = "addCustomer")
    public void addCustomer(){
        customerService.addCustomer();
        customerService.addCustomer();
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
