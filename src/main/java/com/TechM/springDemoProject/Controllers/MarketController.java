package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Market")
public class MarketController
{
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

}


