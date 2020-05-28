package com.example.todo.services.daily;

import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.repositories.daily.DailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailySaleServiceImpl implements DailySaleService {
    private final DailySaleRepo dailySaleRepo;

    @Override
    public void saveDailySale(DailySale dailySale) {
        log.warn("saving daily sale");
    }
}
