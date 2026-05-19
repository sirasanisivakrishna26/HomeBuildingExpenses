package com.hcl.gl.Entity;

import java.util.List;

public class CategorySummaryDTO {

    private String category;

    private Double totalAmount;

    private List<Expense> expenses;

    public CategorySummaryDTO() {
    }

    public CategorySummaryDTO(
            String category,
            Double totalAmount,
            List<Expense> expenses) {

        this.category = category;
        this.totalAmount = totalAmount;
        this.expenses = expenses;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
