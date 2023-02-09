package com.TechM.springDemoProject.Controllers;


import com.TechM.springDemoProject.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    CustomerService customerService;



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
