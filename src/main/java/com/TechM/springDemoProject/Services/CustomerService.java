package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Controllers.CustomerMarketDTO;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import com.TechM.springDemoProject.Repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerService {
    private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MarketRepository marketRepository;


    public void addCustomer() {
        Customer customer = new Customer();
        customer.setCustomerFirstName("Mona");
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

    public  Customer getCustomerByCreatedDate(Date createdDate){
        Customer customer = customerRepository.getCustomerByCreatedDate(createdDate);
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


    public List<Customer> getAllActiveCustomers() {
        List<Customer> customers = customerRepository.findAllActive();
        return customers;
    }

    public List<Customer> getAllInActiveCustomers() {
        List<Customer> customers = customerRepository.findAllInActive();
        return customers;
    }

    public Customer findTopByOrderById() {
        Customer customer = customerRepository.findTopByOrderById();
        return customer;

    }

    public List<Customer> findTopByOrderByUpdated() {
        List<Customer> customer = customerRepository.findTopByOrderByUpdated();
        return customer;
    }


    public void deleteByIdIsActive(Integer id) {
        customerRepository.deleteByIdIsActive(id);

    }


    public void deleteCustomersByFirstName(String customerFirstName) {
        customerRepository.deleteByCustomerFirstName(customerFirstName);
    }

    public void deleteAll() {
        customerRepository.deleteAll();

    }


    public void createCustomer(String firstName, String lastName, String contact, String stringDate, boolean isValid, Integer marketId) throws ParseException {
        Customer customer = new Customer();
        customer.setCustomerFirstName(firstName);
        customer.setCustomerSecondName(lastName);
        customer.setContact(contact);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convetedDate = formatter.parse(stringDate);
        customer.setCreatedDate(convetedDate);
        customer.setIsActive(isValid);
        Market market = marketRepository.getMarketById(marketId);
        customer.setMarket(market);
        customerRepository.save(customer);
    }


    public void deleteCustomerByID(Integer id) {
        Customer customer = customerRepository.getCustomerById(id);
        customer.setIsActive(false);
        customerRepository.save(customer);
    }


    public void deleteCustomerFirstName(String customerFirstName) {
        Customer customer = customerRepository.getCustomerByFirstName(customerFirstName);
        customer.setIsActive(false);
        customerRepository.save(customer);
    }


    public void deleteAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer: customers) {
            customer.setIsActive(false);

        }
        customerRepository.saveAll(customers);
    }

   public void deleteCustomerByMarketId(Integer id){
       List<Customer> customers = customerRepository.findByMarketId(id);
       for (Customer customer: customers) {
           customer.setIsActive(false);

       }
       customerRepository.saveAll(customers);

   }


    public void deleteCustomerByCreatedDate(Date createdDate){
        Iterable<Customer> customers = customerRepository.findByCreatedDate(createdDate);
        for (Customer customer: customers) {
            customer.setIsActive(false);

        }
        customerRepository.saveAll(customers);

    }

    public void deleteCustomerByUpdatedDate(Date updatedDate) {
        Iterable<Customer> customers = customerRepository.findByUpdatedDate(updatedDate);
        for (Customer customer : customers) {
            customer.setIsActive(false);
        }
        customerRepository.saveAll(customers);
    }



    public void deleteByCreatedAfterDate(Date date) {
        Iterable<Customer> customers = customerRepository.findByCreatedDateAfter(date);
        for (Customer customer: customers) {
            customer.setIsActive(false);

        }
        customerRepository.saveAll(customers);

    }


    public Customer getCustomerByUpdatedDate(Date updatedDate) {
        Customer customer=customerRepository.getCustomerByUpdatedDate(updatedDate);
        return  customer;
    }
}



