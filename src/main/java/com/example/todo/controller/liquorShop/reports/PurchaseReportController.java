package com.example.todo.controller.liquorShop.reports;

import com.example.todo.services.report.PurchaseReportService;
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
public class PurchaseReportController {

    private final PurchaseReportService reportService;


    @GetMapping("/users/{username}/getPurchaseReportByShopName/{shopName}/{type}/{packagingType}")
    public ResponseEntity<List> getStockPositionByShopName(@PathVariable String username, @PathVariable String shopName,
                                                           @PathVariable String type, @PathVariable String packagingType,
                                                           @RequestParam("localDateFrom")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                           @RequestParam("localDateTo")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                   LocalDate to) {
        System.out.println("localdate from:" + from + " : local date to: " + to);
        return new ResponseEntity<List>(reportService.findByShopName(shopName, from, to, type, packagingType), HttpStatus.OK);
    }

    @GetMapping("/users/{username}/getPurchaseReportByCityName/{cityName}/{type}/{packagingType}")
    public ResponseEntity<List> getStockPositionByCityName(@PathVariable String username, @PathVariable String cityName,
                                                           @PathVariable String type, @PathVariable String packagingType,
                                                           @RequestParam("localDateFrom")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                           @RequestParam("localDateTo")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                   LocalDate to) {
        System.out.println("localdate from:" + from + " : local date to: " + to);
        return new ResponseEntity<List>(reportService.findByCityName(cityName, from, to, type, packagingType), HttpStatus.OK);
    }


    @GetMapping("/users/{username}/getPurchaseReportByDistrictName/{districtName}/{type}/{packagingType}")
    public ResponseEntity<List> getPurchaseReportByDistrictName(@PathVariable String username, @PathVariable String districtName,
                                                                @PathVariable String type, @PathVariable String packagingType,
                                                                @RequestParam("localDateFrom")
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                                @RequestParam("localDateTo")
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                        LocalDate to) {
        System.out.println("localdate from:" + from + " : local date to: " + to);
        return new ResponseEntity<List>(reportService.findByDistrictName(districtName, from, to, type, packagingType), HttpStatus.OK);
    }
}
