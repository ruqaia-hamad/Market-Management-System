package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "Item/getAll", method = RequestMethod.GET)
    public List<Item> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return items;
    }


    @RequestMapping(value = "Item/getById", method = RequestMethod.GET)
    public Item getItemById(@RequestParam Integer itemId) {
        Item item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping(value = "Item/getByPrice", method = RequestMethod.GET)
    public Item getItemByPrice(@RequestParam Integer price) {
        Item item = itemService.getItemByPrice(price);
        return item;
    }

    @RequestMapping(value = "Item/getByName", method = RequestMethod.GET)
    public Item getItemByName(@RequestParam String name) {
        Item item = itemService.getItemByName(name);
        return item;
    }
    @GetMapping(value = "addItem")
    public void addItem() {
        itemService.addItem();
        itemService.addItem();
    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<Item> getAllActiveItems() {
        List<Item> items= itemService.getAllActiveItems();
        return items;
    }

}
