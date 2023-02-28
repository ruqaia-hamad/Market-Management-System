package com.TechM.springDemoProject.RequestObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MarketRequestForCreateDateUpdate {

    String date;
    Integer id;

}
