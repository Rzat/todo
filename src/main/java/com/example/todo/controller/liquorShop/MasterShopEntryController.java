package com.example.todo.controller.liquorShop;


import com.example.todo.domain.liquorMasterDomain.MasterShopEntry;
import com.example.todo.services.MasterShopEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MasterShopEntryController {

    private final MasterShopEntryService masterShopEntryService;

    @PostMapping("/users/{username}/AddMasterShopEntry")
    public ResponseEntity<MasterShopEntry> saveMasterShop(@PathVariable String username,
                                                          @RequestBody MasterShopEntry entry) {
        masterShopEntryService.save(entry);
        return new ResponseEntity<MasterShopEntry>(HttpStatus.CREATED);


    }
}
