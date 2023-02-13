package com.TechM.springDemoProject.Controllers;

public class CustomerMarketDTO {

    private String customerFirstName;
    private String customerSecondName;
    private String marketName;

    public CustomerMarketDTO(String customerFirstName, String customerSecondName, String marketName) {
        this.customerFirstName = customerFirstName;
        this.customerSecondName = customerSecondName;
        this.marketName = marketName;
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

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
