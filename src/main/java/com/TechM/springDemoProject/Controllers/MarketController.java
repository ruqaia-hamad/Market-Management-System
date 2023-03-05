package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.RequestObject.CustomerRequestForCreateCustomer;
import com.TechM.springDemoProject.RequestObject.MarketRequestForCreateDateUpdate;
import com.TechM.springDemoProject.Services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.invoke.ParameterMappingException;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Market")
public class MarketController {
    @Autowired
    MarketService marketService;

    @RequestMapping(value = "Market/getAll", method = RequestMethod.GET)
    public List<Market> getAllMarkets() {
        List<Market> markets = marketService.getAllMarkets();
        return markets;
    }

    @RequestMapping(value = "Market/getById", method = RequestMethod.GET)
    public Market getMarketById(@RequestParam Integer marketId) {
        Market market = marketService.getMarketById(marketId);
        return market;
    }

    @RequestMapping(value = "Market/getByName", method = RequestMethod.GET)
    public Market getMarketByName(@RequestParam String name) {
        Market market = marketService.getMarketByName(name);
        return market;
    }


    @GetMapping(value = "addMarket")
    public void addMarket() {
        marketService.addMarket();

    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<Market> getAllActiveMarkets() {
        List<Market> markets = marketService.getAllMarkets();
        return markets;
    }

    @RequestMapping(value = "/getInActive", method = RequestMethod.GET)
    public List<Market> getAllInActiveMarkets() {
        List<Market> markets = marketService.getAllInActiveMarkets();
        return markets;
    }

    @RequestMapping(value = "/getLatestRow", method = RequestMethod.GET)
    public Market findTopByOrderById() {
        Market market = marketService.findTopByOrderById();
        return market;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteByIdIsActive(Integer id) {
        marketService.deleteByIdIsActive(id);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public void deleteMarketByID(Integer id) {
        marketService.deleteMarketByID(id);
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
    public void deleteByMarketName(String name) {
        marketService.deleteMarketByName(name);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        marketService.deleteAll();
    }


    @RequestMapping(value = "/updateCreatedDateUserInput", method = RequestMethod.POST)
    public void setCreatedDateByUserInput(@RequestBody MarketRequestForCreateDateUpdate data) throws ParseException {
        marketService.setCreatedDateByUserInput(data.getDate(), data.getId());
    }

    @RequestMapping(value = "/createMarket", method = RequestMethod.POST)
    public void createMarket(@RequestBody MarketRequestForCreateDateUpdate marketRequest) throws ParseException {
        marketService.createNewMarket(marketRequest.getCreatedDate(), marketRequest.getName(), marketRequest.getIsActive());


    }

    @RequestMapping(value = "deleteAllItems", method = RequestMethod.GET)
    public void deleteAllItems() {
        marketService.deleteAllItems();
    }

    @RequestMapping(value="/deleteByUpdatedDate", method = RequestMethod.GET)
    public void deleteByUpdatedDate(@RequestParam("updatedDate") Date updatedDate) {
        marketService.deleteByUpdatedDate(updatedDate);
    }

    @RequestMapping(value="/deleteByCreatedDate", method = RequestMethod.GET)
    public void deleteByCreatedDate(@RequestParam("createdDate") Date createdDate) {
        marketService.deleteByCreatedDate(createdDate);
    }

    @RequestMapping(value="/deleteByCreatedAfterDate", method = RequestMethod.GET)
    public void deleteByAfterCreatedDate(@RequestParam("date") Date date) {
        marketService.deleteByCreatedAfterDate(date);
    }
}


