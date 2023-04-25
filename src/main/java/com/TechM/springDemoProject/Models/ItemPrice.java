package com.TechM.springDemoProject.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Data
@Entity
public class ItemPrice extends  BaseEntity{

    ItemPrice(){
        customerRefId = 0;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double priceId;

    private Date datePaid;

    @NotNull
    private Integer customerRefId;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;


}
