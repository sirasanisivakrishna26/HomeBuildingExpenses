package com.hcl.gl.Service;

import com.hcl.gl.Entity.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BudgetClient {

    private final RestTemplate restTemplate;

    public BudgetClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String checkBudget(Expense expense) {


        expense.setCategory(expense.getCategory());
        expense.setAmount(expense.getAmount());

        String url =
                "http://localhost:8082/budgets/check";

        ResponseEntity<Map> response =
                restTemplate.postForEntity(
                        url,
                        expense,
                        Map.class
                );

        return response.getBody()
                .get("status")
                .toString();
    }
}