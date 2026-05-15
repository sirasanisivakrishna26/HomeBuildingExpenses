package com.hcl.gl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController {

    @GetMapping("/")
    public String home() {
        return "Budget Service Live";
    }
}
