package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
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
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {


    Iterable<Invoice> findByUpdatedDate(@Param("updatedDate") Date updatedDate);
    Iterable<Invoice> findByCreatedDate(@Param("createdDate")Date createdDate);
    Iterable<Invoice> findByCreatedDateAfter(Date date);
    @Query(value = "SELECT m FROM Invoice m")
    List<Invoice> getAllInvoices();

    @Query(value = "SELECT i FROM Invoice i where i.id= :invoiceId")
    Invoice getInvoiceById(@Param("invoiceId") Integer id);

    @Query(value = "SELECT i FROM Invoice i where i.email= :email")
    Invoice getInvoiceByEmail(@Param("email") String email);


    @Query(value = "SELECT i FROM Invoice i where i.fax= :fax")
    Invoice getInvoiceByFax(@Param("fax") String fax);

    @Query(value = "SELECT i FROM Invoice i where i.website= :website")
    Invoice getInvoiceByWebsite(@Param("website") String website);

    @Query("SELECT i FROM Invoice i WHERE i.isActive = true")
    List<Invoice> findAllActive();

    @Query("SELECT i FROM Invoice i WHERE i.isActive = false")
    List<Invoice> findAllInActive();

    @Query(value = "SELECT i FROM Invoice i WHERE i.customer.id = :customer_Id")
    List<Invoice> findByCustomerId(@Param("customer_Id") Integer customer_Id);

    @Query("SELECT i FROM Invoice i WHERE i.id = (SELECT MAX(i.id) FROM Invoice i)")

    Invoice findTopByOrderById();

    @Modifying
    @Transactional
    @Query("DELETE FROM Invoice i WHERE i.id = :id")
    void deleteByIdIsActive(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query("DELETE FROM Invoice i WHERE i.email = :email")
    void deleteByInvoiceEmail(@Param("email") String email);


    @Modifying
    @Query("DELETE FROM Invoice e")
    void deleteAll();

    @Query(value = "SELECT i FROM Invoice i where i.createdDate= :createdDate")
   Invoice getInvoiceByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT i FROM Invoice i where i.updatedDate= :updatedDate")
    Invoice getInvoiceByUpdatedDate(@Param("updatedDate") Date updatedDate);

    List<Invoice> findByCustomerMarketId(Integer marketId);

}

