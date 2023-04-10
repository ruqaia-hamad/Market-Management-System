package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MarketCustomerDTO {

 private Integer customer_Id;

    private String customerFirstName;
    private String customerSecondName;

    private String marketName;

}
