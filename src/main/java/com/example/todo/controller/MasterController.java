package com.example.todo.controller;

import com.example.todo.domain.masterDomain.MasterBrandNameEntry;
import com.example.todo.repositories.MasterBrandEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MasterController {

    private final MasterBrandEntryRepo repository;

    @PostMapping("/users/{username}/MasterBrandEntry")
    public ResponseEntity<MasterBrandNameEntry> addMaster(@PathVariable String username, @RequestBody MasterBrandNameEntry entry) {
        System.out.println("In the adding master");
        return new ResponseEntity<MasterBrandNameEntry>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}/MasterBrandE ntry")
    public ResponseEntity<List<MasterBrandNameEntry>> getALl() {

        return new ResponseEntity<List<MasterBrandNameEntry>>(repository.findAll(), HttpStatus.OK);
    }

}
