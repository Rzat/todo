package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.MasterBrandEntryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MasterBrandEntryServiceImpl implements MasterBrandEntryService {

    private final MasterBrandEntryRepo masterBrandEntryRepo;
    private final AddingParchaRepo parchaRepo;
    AddingParcha addingParcha = new AddingParcha();


    @Override
    @Transactional
    public MasterBrandNameEntry savMasterBrandNameEntry(MasterBrandNameEntry masterBrandNameEntry) {
        if (masterBrandNameEntry.getId() == 0) {

            addingParcha.setId(masterBrandNameEntry.getId());
            addingParcha.setBrandName(masterBrandNameEntry.getBrandName());
            //adding new column brand type in Adding Parcha
            addingParcha.setBrandType(masterBrandNameEntry.getBrandType());
            parchaRepo.save(addingParcha);
            return masterBrandEntryRepo.save(masterBrandNameEntry);
        } else {
            //    masterBrandEntryRepo.deleteById(masterBrandNameEntry.getId());
            //     return masterBrandEntryRepo.save(masterBrandNameEntry);
            Optional<MasterBrandNameEntry> entryOptional = Optional.of(masterBrandNameEntry);
            MasterBrandNameEntry masterBrandNameEntry1 = entryOptional.get();
            masterBrandNameEntry1.setBrandCategoryName(masterBrandNameEntry.getBrandCategoryName());
            masterBrandNameEntry1.setBrandCompanyName(masterBrandNameEntry.getBrandCompanyName());
            masterBrandNameEntry1.setBrandName(masterBrandNameEntry.getBrandName());
            masterBrandNameEntry1.setBrandType(masterBrandNameEntry.getBrandType());
            masterBrandNameEntry1.setPacking1(masterBrandNameEntry.getPacking1());
            masterBrandNameEntry1.setPacking2(masterBrandNameEntry.getPacking2());
            masterBrandNameEntry1.setPacking3(masterBrandNameEntry.getPacking3());


            addingParcha.setId(masterBrandNameEntry.getId());
            addingParcha.setBrandName(masterBrandNameEntry.getBrandName());


            parchaRepo.save(addingParcha);

            return masterBrandEntryRepo.save(masterBrandNameEntry1);
        }
    }


    @Override
    public List findAll() {
        List<MasterBrandNameEntry> brandNameEntryList = new ArrayList<>();
        masterBrandEntryRepo.findAll().iterator().forEachRemaining(brandNameEntryList::add);
        return brandNameEntryList;
    }

    @Override
    public MasterBrandNameEntry getBrandById(Long id) {
        Optional<MasterBrandNameEntry> entry = masterBrandEntryRepo.findById(id);
        if (!entry.isPresent()) {
            log.error("No Such id found");
        }
        return entry.get();
    }

    @Override
    public Boolean deleteBrandById(Long id) {
        //Optional<MasterBrandNameEntry> entry = masterBrandEntryRepo.findById(id);
        try {
            masterBrandEntryRepo.deleteById(id);
            parchaRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("No Such id Found");
            return false;
        }
    }


}
