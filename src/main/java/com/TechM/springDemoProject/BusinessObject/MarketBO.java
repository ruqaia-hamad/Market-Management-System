package com.TechM.springDemoProject.BusinessObject;

import javax.persistence.Column;

public class MarketBO {

    @Column(name = "Market_name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
