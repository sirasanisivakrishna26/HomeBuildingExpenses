package com.hcl.gl;

import com.hcl.gl.DTO.ExpenseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/budgets")
public class BudgetController {

    @GetMapping("/")
    public String home() {
        return "Budget Service Live";
    }

    @PostMapping("/check")
    public Map<String, String> checkBudget(
            @RequestBody ExpenseDTO dto) {

        Map<String, String> response =
                new HashMap<>();
        if(dto.getAmount() > 5000) {

            response.put(
                    "status",
                    "BUDGET_EXCEEDED"
            );


        } else {

            response.put(
                    "status",
                    "LIMIT_OK"
            );
        }

        return response;
    }



}