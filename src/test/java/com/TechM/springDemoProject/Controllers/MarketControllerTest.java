package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Market;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarketControllerTest {
@Autowired
MarketController marketController;
    @Test
    void getAllMarkets() {
            List<Market> markets = marketController.getAllMarkets();

            for (Market market : markets) {
                assertNotNull(market.getId());
                assertNotNull(market.getName());
                assertNotNull(market.getIsActive());
                assertNotNull(market.getCreatedDate());
                assertNotNull(market.getUpdatedDate());
            }
    }

    @Test
    void getMarketById() {
        String marketName = marketController.getMarketById(4).getName();
        assertEquals("jeem", marketName);
    }

    @Test
    void getMarketById2() {
        String marketName = marketController.getMarketById(1).getName();
        assertEquals("LULO HYPERMARKET", marketName);
    }
    @Test
    void getMarketById3() {
        String marketName = marketController.getMarketById(2).getName();
        assertEquals("LULO HYPERMARKET", marketName);
    }
    @Test
    void getAllActiveMarkets() {
        List<Market> markets = marketController.getAllMarkets();
        for (Market market :markets){
            assertFalse(markets.isEmpty());
        }
    }

}