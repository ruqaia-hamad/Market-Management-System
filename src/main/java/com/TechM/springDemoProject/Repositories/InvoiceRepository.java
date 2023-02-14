package com.TechM.springDemoProject.Repositories;

import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
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

}
