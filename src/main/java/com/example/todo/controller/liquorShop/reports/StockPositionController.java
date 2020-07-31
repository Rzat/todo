package com.example.todo.controller.liquorShop.reports;


import com.example.todo.domain.liquorMasterDomain.reports.StockPosition;
import com.example.todo.services.report.StockPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StockPositionController {

    private final StockPositionService stockPositionService;

    @PostMapping("/users/{username}/getStockPosition")
    public ResponseEntity<StockPosition> getStockPosition2(@PathVariable String username, @RequestBody StockPosition stockPosition) {
        System.out.println("inside get stock position" + stockPosition);
        return new ResponseEntity<StockPosition>(HttpStatus.OK);
    }


    @GetMapping("/users/{username}/getStockPositionByShopName/{shopName}/{type}/{packagingType}")
    public ResponseEntity<String> getStockPositionByShopName(@PathVariable String username, @PathVariable String shopName,
                                                             @PathVariable String type, @PathVariable String packagingType,
                                                             @RequestParam("localDate")
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        System.out.println("inside get stock position" + shopName);
        //LocalDate date = LocalDate.now();
        stockPositionService.findByShopNameAndDate(shopName, localDate);

        return new ResponseEntity<String>(HttpStatus.OK);
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
