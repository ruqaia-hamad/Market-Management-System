package com.TechM.springDemoProject.Models;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "Customers")
public class Customer extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "First_Name")
    private String customerFirstName;

    @Column(name = "Second_Name")
    private String customerSecondName;

    //  @Column(name="contact")
    private String contact;

    // @OneToMany
    //@JoinColumn(referencedColumnName = "id")
    // List<Invoice> invoice;

    public Market getMarket() {
        return market;
    }


    public void setMarket(Market market) {
        this.market = market;
    }

    @ManyToOne
    @JoinColumn(name = "market_Id", referencedColumnName = "id")
    Market market;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerSecondName() {
        return customerSecondName;
    }

    public void setCustomerSecondName(String customerSecondName) {
        this.customerSecondName = customerSecondName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
