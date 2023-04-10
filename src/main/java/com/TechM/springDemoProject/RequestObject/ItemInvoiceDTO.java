package com.TechM.springDemoProject.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ItemInvoiceDTO {
    Integer id ;

    String email;

    String fax;

    String website;
    String name;

    public ItemInvoiceDTO(Integer id, String email, String fax, String website, String name) {
        this.id = id;
        this.email = email;
        this.fax = fax;
        this.website = website;
        this.name = name;
    }
}
