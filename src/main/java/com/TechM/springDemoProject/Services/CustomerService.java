package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Controllers.CustomerMarketDTO;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerService {
    private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());
    @Autowired
    CustomerRepository customerRepository;


    public void addCustomer() {
        Customer customer = new Customer();
        customer.setCustomerFirstName("Ahmed");
        customer.setCustomerSecondName("Hamed");
        customer.setContact("96473634");
        customerRepository.save(customer);
        LOG.info("Added customer: " + customer);
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public void deleteCustomerById(Integer id) {
        Customer customerToDelete = customerRepository.findById(id).get();
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = customerRepository.getCustomerById(id);
        return customer;
    }

    public Customer getCustomerByFirstName(String customerFirstName) {
        Customer customer = customerRepository.getCustomerByFirstName(customerFirstName);
        return customer;

    }

    public Customer getCustomerBySecondName(String customerSecondName) {
        Customer customer = customerRepository.getCustomerBySecondName(customerSecondName);
        return customer;

    }

    public Customer getCustomerByContact(String contact) {
        Customer customer = customerRepository.getCustomerByContact(contact);
        return customer;

    }

    public List<Customer> getCustomerByMarketId1(Integer Market_Id) {
        List<Customer> customer = customerRepository.findByMarketId(Market_Id);
        return customer;
    }

    public List<CustomerMarketDTO> getCustomerByMarketId(Integer Market_Id) {
        List<CustomerMarketDTO> customers = customerRepository.findCustomerByMarketId(Market_Id);
        return customers;
    }
}
