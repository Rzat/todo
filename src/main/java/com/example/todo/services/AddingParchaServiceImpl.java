package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.daily.DailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddingParchaServiceImpl implements AddingParchaService {

    private final AddingParchaRepo parchaRepo;
    private final DailySaleRepo dailySaleRepo;

    @Override
    public List<AddingParcha> findAll() {
        List<AddingParcha> parchaList = new ArrayList<>();
        parchaRepo.findAll().iterator().forEachRemaining(parchaList::add);
        return parchaList;
    }


    @Override
    public List<AddingParcha> findByShopName(String shopName) {
        return parchaRepo.findAllByShopName(shopName).stream().collect(Collectors.toList());

    }

    @Override
    public AddingParcha findByShopAndBrandName(String shopName, String brandName) {
        Optional<AddingParcha> findRateList = parchaRepo.findByShopNameAndBrandName(shopName, brandName);
        return findRateList.get();
    }

    @Override
    @Transactional
    public AddingParcha saveParcha(AddingParcha parcha) {
        AddingParcha addingParcha = new AddingParcha();
        addingParcha.setBrandName(parcha.getBrandName());
        addingParcha.setNumbr(parcha.getNumbr());
        addingParcha.setQuarts(parcha.getQuarts());
        addingParcha.setPints(parcha.getPints());
        addingParcha.setNips(parcha.getNips());
        addingParcha.setShopName(parcha.getShopName());
        DailySale dailySale = new DailySale();
        dailySale.setBrandName(parcha.getBrandName());
        dailySale.setShopName(parcha.getShopName());
        dailySaleRepo.save(dailySale);
        return parchaRepo.save(addingParcha);
      /*  Optional<AddingParcha> optionalAddingParcha = Optional.of(parcha);
        if (optionalAddingParcha.isPresent()) {
            AddingParcha addingParcha = optionalAddingParcha.get();
            addingParcha.setBrandName(parcha.getBrandName());
            addingParcha.setNumbr(parcha.getNumbr());
            addingParcha.setQuarts(parcha.getQuarts());
            addingParcha.setPints(parcha.getPints());
            addingParcha.setNips(parcha.getNips());
            addingParcha.setShopName(parcha.getShopName());
            return parchaRepo.save(addingParcha);
        } else {
            log.error("Parcha not found");
            return new AddingParcha();
        }*/

    }


}
