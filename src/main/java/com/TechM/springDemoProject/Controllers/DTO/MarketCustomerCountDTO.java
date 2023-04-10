package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class MarketCustomerCountDTO {
    private String name;
    private Integer customerCount;
}
