package com.example.todo.controller.liquorShop.daily;


import com.example.todo.domain.liquorMasterDomain.daily.DailyPurchase;
import com.example.todo.services.daily.DailyPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DailyPurchaseController {

    private final DailyPurchaseService service;


    @GetMapping("/users/{username}/dailyPurchase")
    public ResponseEntity<List<DailyPurchase>> getAll(@PathVariable String username) {
        List<DailyPurchase> list = service.findAll();
        return new ResponseEntity<List<DailyPurchase>>(list, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/saveDailyPurchase")
    public ResponseEntity<DailyPurchase> saveDailyPurchase(@PathVariable String username, @RequestBody DailyPurchase purchase) throws Exception {
        // service.saveDailyPurchase(purchase);
        System.out.println(purchase);
        service.newSaveDailyPurchase(purchase);

        return new ResponseEntity<DailyPurchase>(HttpStatus.CREATED);
    }
}
