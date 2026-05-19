package com.hcl.gl.Repo;

import com.hcl.gl.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer> {


}
