package com.TechM.springDemoProject.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class InvoiceRequest {


    String email;

    String fax;

    String website;

    Integer customerId;

    String createdDate;
    Boolean isActive;

}
