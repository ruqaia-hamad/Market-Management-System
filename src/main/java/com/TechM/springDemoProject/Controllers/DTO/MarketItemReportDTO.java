package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class MarketItemReportDTO {

    private String name;
    private String  topSellingItem;
}
