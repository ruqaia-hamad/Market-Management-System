package com.TechM.springDemoProject.RequestObject;

import com.TechM.springDemoProject.Models.Invoice;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ItemRequest {

    String name;
    Integer id;
    Integer price;
    Integer InvoiceId;
    String CreatedDate;
    Boolean IsActive;

}
