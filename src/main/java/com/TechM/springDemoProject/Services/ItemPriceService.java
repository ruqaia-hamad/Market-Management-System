package com.TechM.springDemoProject.Services;


import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.ItemPrice;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import com.TechM.springDemoProject.Repositories.ItemPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ItemPriceService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemPriceRepository itemPriceRepository;


    public void addToItemPrice(Double priceId, Date datePaid, Date createdDate, boolean isValid, Integer customerId) throws ParseException {
//        ItemPrice itemPrice = new ItemPrice();
//        itemPrice.setPriceId(priceId);
//        itemPrice.setDatePaid(datePaid);
//        itemPrice.setCreatedDate(createdDate);
//        itemPrice.setIsActive(isValid);
//        Customer customer = customerRepository.getCustomerById(customerId);
//        if (customer == null) {
//            throw new IllegalArgumentException("Invalid customerId: " + customerId);
//        }
//        itemPrice.setCustomer(customer);
//        itemPriceRepository.save(itemPrice);
    }

    public void createItemPrice(ItemPrice itemPrice) throws ParseException {
        itemPriceRepository.save(itemPrice);
    }
}
