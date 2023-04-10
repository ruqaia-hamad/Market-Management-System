package com.TechM.springDemoProject.Controllers.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CustomerReportDTO {

    private String name;
    private String contact;
    private Integer totalInvoices;
    private Integer totalItemsSold;
}
