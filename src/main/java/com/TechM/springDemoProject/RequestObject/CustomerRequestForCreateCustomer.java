package com.TechM.springDemoProject.RequestObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class CustomerRequestForCreateCustomer {

    String firstName;
    String secondName;
    String contact;
    String createdDate;
    Boolean isActive;

    Integer marketId;




}
