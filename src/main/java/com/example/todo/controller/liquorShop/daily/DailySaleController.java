package com.example.todo.controller.liquorShop.daily;


import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import com.example.todo.repositories.daily.DailySaleRepo;
import com.example.todo.services.daily.DailySaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DailySaleController {
    private final DailySaleRepo dailySaleRepo;
    private final DailySaleService dailySaleService;

    @GetMapping("/users/{username}/findDailySaleByShopName/{shopName}")
    public ResponseEntity<List<DailySale>> findByShopName(@PathVariable String username, @PathVariable String shopName) {
        return new ResponseEntity<List<DailySale>>(dailySaleRepo.findAllByShopName(shopName), HttpStatus.OK);
    }

    @PostMapping("/users/{username}/saveDailySale")
    public ResponseEntity<SaveDailySale> saveDailySale(@PathVariable String username,
                                                       @RequestBody List<SaveDailySale> dailySale) {
        dailySaleService.saveDailySale(dailySale);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
