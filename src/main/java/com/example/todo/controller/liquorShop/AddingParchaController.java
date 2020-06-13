package com.example.todo.controller.liquorShop;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.services.AddingParchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AddingParchaController {

    private final AddingParchaService parchaService;

    @GetMapping("/users/{username}/GetAllParcha")
    public ResponseEntity<List<AddingParcha>> getAll() {
        return new ResponseEntity<List<AddingParcha>>(parchaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users/{username}/AddingParcha")
    public ResponseEntity<AddingParcha> addParcha(@PathVariable String username, @RequestBody AddingParcha parcha) {
        parchaService.saveParcha(parcha);
        return new ResponseEntity<AddingParcha>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}/findByShopName/{shopName}")
    public ResponseEntity<List<AddingParcha>> findByShopName(@PathVariable String username, @PathVariable String shopName) {

        return new ResponseEntity<List<AddingParcha>>(parchaService.findByShopName(shopName), HttpStatus.OK);
    }

    @GetMapping("/users/{username}/findShopName/{shopName}/findBeerName/{brandName}")
    public ResponseEntity<AddingParcha> findByShopNameAndBrandName(@PathVariable String shopName,
                                                                         @PathVariable String brandName) {
        return new ResponseEntity<AddingParcha>(parchaService.findByShopAndBrandName(shopName, brandName)
                , HttpStatus.OK);
    }
}
