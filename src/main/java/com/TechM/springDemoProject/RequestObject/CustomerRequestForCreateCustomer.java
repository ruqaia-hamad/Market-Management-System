package com.TechM.springDemoProject.RequestObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerRequestForCreateCustomer {

    String firstName;
    String secondName;
    String contact;


}
