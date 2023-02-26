package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Query("SELECT i FROM Item i WHERE i.isActive = false")
    List<Item> findAllInActive();


    @Query("SELECT i FROM Item i WHERE i.id = (SELECT MAX(i.id) FROM Item i)")

    Item findTopByOrderById();

    @Modifying
    @Transactional
    @Query("DELETE FROM Item i WHERE i.id = :id")
    void deleteByIdIsActive(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Item i WHERE i.name = :name")
    void deleteByItemName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM Item i")
    void deleteAll();

}
