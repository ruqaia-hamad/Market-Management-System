package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Models.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Iterable<Item> findByUpdatedDate(@Param("updatedDate") Date updatedDate);
    Iterable<Item> findByCreatedDate(@Param("createdDate")Date createdDate);
    Iterable<Item> findByCreatedDateAfter(Date date);
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

    @Query(value = "SELECT i FROM Item i WHERE i.invoice.id = :invoice_Id")
    List<Item> findByInvoiceId(@Param("invoice_Id") Integer customer_Id);


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

    @Query(value = "SELECT i FROM Item i where i.createdDate= :createdDate")
    Item getItemByCreatedDate(@Param("createdDate") Date createdDate);


    @Query(value = "SELECT i FROM Item i where i.updatedDate= :updatedDate")
    Item getItemByUpdatedDate(@Param("updatedDate") Date updatedDate);




}
