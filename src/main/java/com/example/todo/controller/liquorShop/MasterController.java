package com.example.todo.controller.liquorShop;

import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;
import com.example.todo.repositories.MasterBrandEntryRepo;
import com.example.todo.services.MasterBrandEntryService;
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
    private final MasterBrandEntryService masterBrandEntryService;

    @PostMapping("/users/{username}/MasterBrandEntry")
    public ResponseEntity<MasterBrandNameEntry> addMaster(@PathVariable String username, @RequestBody MasterBrandNameEntry entry) {
        System.out.println("In the adding master");
        masterBrandEntryService.savMasterBrandNameEntry(entry);
        return new ResponseEntity<MasterBrandNameEntry>(HttpStatus.CREATED);
    }

    @PutMapping("/users/{username}/MasterBrandEntry/{id}")
    public ResponseEntity<MasterBrandNameEntry> updateMaster(@PathVariable String username, @PathVariable Long id, @RequestBody MasterBrandNameEntry entry) {
        System.out.println("In the adding master");
        masterBrandEntryService.savMasterBrandNameEntry(entry);
        return new ResponseEntity<MasterBrandNameEntry>(HttpStatus.CREATED);
    }


    @GetMapping("/users/{username}/MasterBrandEntry")
    public ResponseEntity<List<MasterBrandNameEntry>> getALl(@PathVariable String username) {
        List<MasterBrandNameEntry> listOfEntry = masterBrandEntryService.findAll();
        return new ResponseEntity<List<MasterBrandNameEntry>>(listOfEntry, HttpStatus.OK);
    }


    @GetMapping("/users/{username}/MasterBrandEntry/{id}")
    public ResponseEntity<MasterBrandNameEntry> getById(@PathVariable String username, @PathVariable Long id) {
        MasterBrandNameEntry brandNameEntry = masterBrandEntryService.getBrandById(id);
        return new ResponseEntity<MasterBrandNameEntry>(brandNameEntry, HttpStatus.OK);
    }

    @DeleteMapping("/users/{username}/MasterBrandEntry/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable Long id) {
        Boolean aboolean = masterBrandEntryService.deleteBrandById(id);
        if (aboolean) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }



}
