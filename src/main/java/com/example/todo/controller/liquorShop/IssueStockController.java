package com.example.todo.controller.liquorShop;


import com.example.todo.domain.liquorMasterDomain.IssueStock;
import com.example.todo.services.IssueStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class IssueStockController {

    private final IssueStockService issueStockService;

    @PostMapping("/users/{username}/saveStock")
    public ResponseEntity<IssueStock> saveStock(@PathVariable String username, IssueStock issueStock) {
        issueStockService.saveStock(issueStock);
        return new ResponseEntity<IssueStock>(HttpStatus.CREATED);
    }
}
