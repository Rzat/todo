package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.MasterShopEntry;
import com.example.todo.repositories.MasterShopEntryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MasterShopEntryServiceImpl implements MasterShopEntryService {

    private final MasterShopEntryRepo shopEntryRepo;

    @Override
    public MasterShopEntry save(MasterShopEntry entry) {
        return shopEntryRepo.save(entry);
    }

    @Override
    public List<MasterShopEntry> getShop() {
        List<MasterShopEntry> city = shopEntryRepo.findAll();
        //List<String> list = new ArrayList<>();
        // city.stream().forEach((getCity) -> System.out.println(getCity.getCity()));
        //  city.stream().forEach((getCity) -> list.add(getCity.getCity()));

        //List<MasterShopEntry> list = List.ofAll()
        //System.out.println(list);
        return city;
    }


}
