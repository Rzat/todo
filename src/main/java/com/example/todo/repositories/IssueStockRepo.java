package com.example.todo.repositories;

import com.example.todo.domain.liquorMasterDomain.IssueStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueStockRepo extends JpaRepository<IssueStock, Long> {
}
