package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketRepository marketRepository;

    public List<Market> getAllMarkets() {
        return marketRepository.getAllMarkets();
    }


    public void addMarket() {
        Market market = new Market();
        market.setName("LULO HYPERMARKET");
        marketRepository.save(market);

    }

    public Market getMarketById(Integer id) {
        Market market = marketRepository.getMarketById(id);
        return market;
    }

    public Market getMarketByName(String name) {
        Market market = marketRepository.getMarketByName(name);
        return market;
    }

    public List<Market> getAllActiveMarkets() {
        List<Market>  markets= marketRepository.findAllActive();
        return markets;
    }


}
