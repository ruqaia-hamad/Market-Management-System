package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MarketPerformanceDTO {

    private  String name ;

    private double totalRevenue;

}
