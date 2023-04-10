package com.TechM.springDemoProject.Controllers.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TopSellingItemDTO {
    private String invoiceEmail;
    private String topSellingItemDescription;

    public String getInvoiceEmail() {
        return invoiceEmail;
    }

    public void setInvoiceEmail(String invoiceEmail) {
        this.invoiceEmail = invoiceEmail;
    }

    public String getTopSellingItemDescription() {
        return topSellingItemDescription;
    }

    public void setTopSellingItemDescription(String topSellingItemDescription) {
        this.topSellingItemDescription = topSellingItemDescription;
    }
}

