package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.IssueStock;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.IssueStockRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueStockServiceImpl implements IssueStockService {

    private final AddingParchaRepo addingParchaRepo;
    private final IssueStockRepo stockRepo;

    @Override
    public void saveStock(IssueStock purchase) {
       

    }

}
