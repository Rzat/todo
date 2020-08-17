package com.example.todo.controller.liquorShop.reports;


import com.example.todo.services.report.StockPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StockPositionController {

    private final StockPositionService stockPositionService;

    @GetMapping("/users/{username}/getStockPositionByShopName/{shopName}/{type}/{packagingType}")
    public ResponseEntity<List> getStockPositionByShopName(@PathVariable String username, @PathVariable String shopName,
                                                           @PathVariable String type, @PathVariable String packagingType,
                                                           @RequestParam("localDate")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return new ResponseEntity<List>(stockPositionService.findByShopNameAndDate(shopName, localDate, type, packagingType), HttpStatus.OK);
    }

    @GetMapping("/users/{username}/getStockPositionByCityName/{cityName}/{type}/{packagingType}")
    public ResponseEntity<String> getStockPositionByCityName(@PathVariable String username, @PathVariable String cityName,
                                                             @PathVariable String type, @PathVariable String packagingType) {
        System.out.println("inside get stock by city position" + cityName + "::" + type + "::" + packagingType);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/users/{username}/getStockPositionByGroupName/{GroupName}/{type}/{packagingType}")
    public ResponseEntity<String> getStockPositionByGroupName(@PathVariable String username, @PathVariable String GroupName,
                                                              @PathVariable String type, @PathVariable String packagingType) {
        System.out.println("inside get stock position:: " + GroupName + ":: packagin type:: " + packagingType);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
