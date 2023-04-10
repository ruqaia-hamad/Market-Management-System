package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ItemDistributionDTO {
    private String itemName;
    private Long itemCount;

    public ItemDistributionDTO(String itemName, Long itemCount) {
        this.itemName = itemName;
        this.itemCount = itemCount;
    }
}
