package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Market;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends CrudRepository<Market,Integer> {
    @Qualifier("SELECT m FROM market m")
    List<Market> getAllMarkets();

}
