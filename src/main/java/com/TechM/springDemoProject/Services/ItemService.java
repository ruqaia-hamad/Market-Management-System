package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public void addItem() {
        Item item = new Item();
        item.setId(1);
        item.setName("orange");
        item.setPrice(2);
    }

    public Item getItemById(Integer id) {
        Item item = itemRepository.getItemById(id);
        return item;
    }


    public Item getItemByPrice(Integer price) {
        Item item = itemRepository.getItemByPrice(price);
        return item;
    }

    public Item getItemByName(String name) {
        Item item = itemRepository.getItemByName(name);
        return item;
    }

    public List<Item> getAllActiveItems() {
        List<Item> items = itemRepository.findAllActive();
        return items;
    }

    public List<Item> getAllInActiveItems() {
        List<Item> items = itemRepository.findAllInActive();
        return items;
    }

    public Item findTopByOrderById() {
        Item item = itemRepository.findTopByOrderById();
        return item;

    }


    public void deleteByIdIsActive(Integer id) {
        itemRepository.deleteByIdIsActive(id);

    }
    public void deleteByItemName(String name) {
        itemRepository.deleteByItemName(name);
    }


    public void deleteAll(){
        itemRepository.deleteAll();
    }

}
