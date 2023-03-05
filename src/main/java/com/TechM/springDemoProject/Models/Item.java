package com.TechM.springDemoProject.Models;

import javax.persistence.*;

@Entity
public class Item  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "Item_Description")
    String name;


    @ManyToOne
    @JoinColumn(name = "invoice_Id", referencedColumnName = "id")
    Invoice invoice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
