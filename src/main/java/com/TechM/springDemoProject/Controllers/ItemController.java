package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.RequestObject.InvoiceRequest;
import com.TechM.springDemoProject.RequestObject.ItemRequest;
import com.TechM.springDemoProject.Services.ItemService;
import com.TechM.springDemoProject.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Item")
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @Scheduled(cron="0 1 * * * *")
    public List<Item> getAllItems() {
        List<Item> items = itemService.getAllItems();
        for (Item item : items) {
            slackClient.sendMessage(String.format("Item name:"+ item.getName()));
            slackClient.sendMessage(String.format("Item  Price:"+ item.getPrice()));
            slackClient.sendMessage(String.format("Item  Is Active:"+ item.getIsActive()));
            slackClient.sendMessage(String.format("Item Created Date::"+ item.getCreatedDate()));
            slackClient.sendMessage(String.format("Item Updated Date:"+ item.getUpdatedDate()));
            slackClient.sendMessage(String.format("-----------------------------------"));


        }
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
        List<Item> items = itemService.getAllActiveItems();
        return items;
    }

    @RequestMapping(value = "/getInActive", method = RequestMethod.GET)
    public List<Item> getAllInActiveItems() {
        List<Item> items = itemService.getAllInActiveItems();
        return items;
    }

    @RequestMapping(value = "/getLatestRow", method = RequestMethod.GET)
    public Item findTopByOrderById() {
        Item item = itemService.findTopByOrderById();
        return item;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteByIdIsActive(Integer id) {
        itemService.deleteByIdIsActive(id);
    }

    @RequestMapping(value = "/deleteByID", method = RequestMethod.GET)
    public void deleteItemByID(Integer id) {
        itemService.deleteItemByID(id);
    }


    @RequestMapping(value = "/deleteByname", method = RequestMethod.GET)
    public void deleteByItemName(String name) {
        itemService.deleteItemByName(name);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        itemService.deleteAll();
    }


    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public void createNewItem(@RequestBody ItemRequest itemRequest) throws ParseException {
        itemService.createNewItem(itemRequest.getName(), itemRequest.getPrice(), itemRequest.getInvoiceId(), itemRequest.getCreatedDate(), itemRequest.getIsActive());
    }


    @RequestMapping(value = "deleteAllItems", method = RequestMethod.GET)
    public void deleteAllItems() {
        itemService.deleteAllItems();
    }


    @GetMapping(value = "deleteItemByInvoiceId")
    public void  deleteAllItemsByInvoiceId(@RequestParam Integer id) {
        itemService.deleteAllItemsByInvoiceId(id);

    }

    @RequestMapping(value="/deleteByUpdatedDate", method = RequestMethod.GET)
    public void deleteByUpdatedDate(@RequestParam("updatedDate") Date updatedDate) {
        itemService.deleteByUpdatedDate(updatedDate);
    }

    @RequestMapping(value="/deleteByCreatedDate", method = RequestMethod.GET)
    public void deleteByCreatedDate(@RequestParam("createdDate") Date createdDate) {
        itemService.deleteByCreatedDate(createdDate);

    }


    @RequestMapping(value = "/getByCreatedDate", method = RequestMethod.GET)
    public Item getItemByCreatedDate(Date updatedDate){
        Item item = itemService.getItemByUpdatedDateDate(updatedDate);
        return item;
    }

}