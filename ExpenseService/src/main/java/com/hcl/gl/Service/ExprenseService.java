package com.hcl.gl.Service;

import com.hcl.gl.Entity.CategorySummaryDTO;
import com.hcl.gl.Entity.Expense;
import com.hcl.gl.Repo.ExpenseRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExprenseService {

    private final ExpenseRepo repo;
    private final BudgetClient budgetClient;
    public ExprenseService(ExpenseRepo repo, BudgetClient budgetClient){
        this.repo=repo;
        this.budgetClient = budgetClient;
    }


    public String addExpenses(Expense expense){
        repo.save(expense);
        String status =
                budgetClient.checkBudget(expense);

        return  status;
    }



    public List<Expense> getExpenses(){

        return repo.findAll();
    }

    public CategorySummaryDTO getByCategory(String category){
        List<Expense> expenses=repo.findAll();
        List<Expense> expenses1=expenses.stream().filter(e->category.equalsIgnoreCase(e.getCategory())).sorted(Comparator.comparing(Expense::getExpenseDate)).toList();

        double totalAmount=expenses1.stream().mapToDouble(Expense::getAmount).sum();
        return new CategorySummaryDTO(category,totalAmount,expenses1);
    }

    public String deleteExpenses(Expense expense){
        repo.delete(expense);
        return "Expense Deleted successfully";
    }



    public Expense update(Long id, Expense updatedExpense) {

        Expense existingExpense = repo.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                        new RuntimeException("Expense Not Found"));

        existingExpense.setCategory(updatedExpense.getCategory());
        existingExpense.setDescription(updatedExpense.getDescription());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setExpenseDate(updatedExpense.getExpenseDate());

        return repo.save(existingExpense);
    }

    public Optional<Expense> findExpenseByID(Long id){
        return repo.findById(Math.toIntExact(id));
    }

    public String deleteExpenseById(Long id){
        repo.deleteById(Math.toIntExact(id));
        return "Expense deleted";
    }


}
