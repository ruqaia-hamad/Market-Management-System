package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Models.Market;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends CrudRepository<Market, Integer> {
    @Query(value = "SELECT m FROM Market m")
    List<Market> getAllMarkets();

    @Query(value = "SELECT m FROM Market m where m.id= :marketId")
    Market getMarketById(@Param("marketId") Integer id);


    @Query(value = "SELECT m FROM Market m where m.name=:name")
    Market getMarketByName(@Param("name") String name);

    @Query("SELECT m FROM Market m WHERE m.isActive = true")
    List<Market> findAllActive();
}
