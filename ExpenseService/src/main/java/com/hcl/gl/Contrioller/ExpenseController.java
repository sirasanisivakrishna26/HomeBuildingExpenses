package com.hcl.gl.Contrioller;

import com.hcl.gl.Entity.CategorySummaryDTO;
import com.hcl.gl.Entity.Expense;
import com.hcl.gl.Service.ExprenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController {

    private final ExprenseService exprenseService;

    public ExpenseController(ExprenseService exprenseService) {
        this.exprenseService = exprenseService;
    }

    @PostMapping("/addExpense")
    public String addExpenses(@RequestBody Expense expense) {
        return exprenseService.addExpenses(expense);

    }

    @GetMapping("/getExpenses")
    public List<Expense> getAllExpenses() {
        return exprenseService.getExpenses();
    }


    @GetMapping("/getByCategory/{category}")
    public CategorySummaryDTO getByCategory(@PathVariable String category){
        System.out.println("controller");
        return exprenseService.getByCategory(category);
    }
    @PutMapping("/updateExpenses/")
    public Expense updateExpense(@PathVariable Long id, @PathVariable Expense expense) {
        return exprenseService.update(id, expense);
    }


    @GetMapping("/deleteExpenseById")
    public String deleteExpenseByID(@PathVariable Long id) {
        return exprenseService.deleteExpenseById(id);
    }

    @GetMapping("deleteALlExpenses")
    public String deleteAllExpense(Expense expense) {
        return exprenseService.deleteExpenses(expense);
    }

    @GetMapping("findExpenseById")
    public Optional<Expense> findExpenseById(@PathVariable Long id) {
        return exprenseService.findExpenseByID(id);
    }


}
