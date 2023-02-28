package com.TechM.springDemoProject.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ItemRequest {

    String name;
    Integer price;
    Integer invoiceId;
    String createdDate;
    Boolean isActive;

}
