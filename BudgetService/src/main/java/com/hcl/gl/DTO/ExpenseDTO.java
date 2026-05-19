package com.hcl.gl.DTO;

import lombok.Data;

@Data
public class ExpenseDTO {

    private String category;
    private Double amount;

    public String getCategory() {
        return category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}