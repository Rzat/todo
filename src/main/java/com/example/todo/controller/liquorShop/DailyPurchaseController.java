package com.example.todo.controller.liquorShop;


import com.example.todo.domain.liquorMasterDomain.DailyPurchase;
import com.example.todo.services.DailyPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DailyPurchaseController {

    private final DailyPurchaseService service;

    @PostMapping("/users/{username}/dailyPurchase")
    public ResponseEntity<DailyPurchase> dailyPurchase(@PathVariable String username, @RequestBody DailyPurchase purchase) {
        service.saveDailyPurchase(purchase);
        System.out.println(purchase);

        return new ResponseEntity<DailyPurchase>(HttpStatus.CREATED);
    }
}
