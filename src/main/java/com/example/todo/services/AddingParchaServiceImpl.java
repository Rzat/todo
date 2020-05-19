package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.repositories.AddingParchaRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddingParchaServiceImpl implements AddingParchaService {

    private final AddingParchaRepo parchaRepo;

    @Override
    public List<AddingParcha> findAll() {
        List<AddingParcha> parchaList = new ArrayList<>();
        parchaRepo.findAll().iterator().forEachRemaining(parchaList::add);
        return parchaList;
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
