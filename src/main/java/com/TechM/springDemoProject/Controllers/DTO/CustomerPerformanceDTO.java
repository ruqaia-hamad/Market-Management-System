package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerPerformanceDTO {

    private String name;
    private String contact;
    private double totalRevenue;

    public CustomerPerformanceDTO(String name, String contact, double totalRevenue) {
        this.name = name;
        this.contact = contact;
        this.totalRevenue = totalRevenue;
    }
}
