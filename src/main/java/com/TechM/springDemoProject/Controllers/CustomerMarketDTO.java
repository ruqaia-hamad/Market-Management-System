package com.TechM.springDemoProject.Controllers;

public class CustomerMarketDTO {

    private String name;
    private String customerFirstName;

    private  Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerMarketDTO(String name, String customerFirstName, Integer id) {
        this.name = name;
        this.customerFirstName = customerFirstName;
        this.id = id;
    }
}



