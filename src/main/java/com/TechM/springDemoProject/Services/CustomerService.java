package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CustomerService {
    private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());
    @Autowired
    CustomerRepository customerRepository;


    public void addCustomer() {
        Customer customer=new Customer();
        customer.setCustomerFirstName("Ahmed");
        customer.setCustomerSecondName("Hamed");
        customer.setContact("96473634");
        customerRepository.save(customer);
        LOG.info("Added customer: " + customer);
    }

    public void deleteCustomerById(Integer id) {
        Customer customerToDelete=customerRepository.findById(id).get();
    }

}
