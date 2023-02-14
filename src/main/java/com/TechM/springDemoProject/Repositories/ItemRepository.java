package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    @Query(value = "SELECT m FROM Item m")
    List<Item> getAllItems();


    @Query(value = "SELECT i FROM Item i where i.id= :itemId")
    Item getItemById(@Param("itemId") Integer id);


    @Query(value = "SELECT i FROM Item i where i.price= :price")
    Item getItemByPrice(@Param("price") Integer price);


    @Query(value = "SELECT i FROM Item i where i.name= :name")
    Item getItemByName(@Param("name") String name);

    @Query("SELECT i FROM Item i WHERE i.isActive = true")
    List<Item> findAllActive();

}
