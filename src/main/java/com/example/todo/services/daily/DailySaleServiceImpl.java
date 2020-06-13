package com.example.todo.services.daily;

import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.repositories.daily.DailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailySaleServiceImpl implements DailySaleService {
    private final DailySaleRepo dailySaleRepo;

    // TODO: 5/31/2020 try to implement log file using slf4j instead of Logger
    private static final Logger logger = Logger.getLogger(DailySaleServiceImpl.class);

    @Override
    public void saveDailySale(List<DailySale> dailySale) {

        for (DailySale sale : dailySale) {
//         logger.error("debugger at work");
            dailySaleRepo.save(sale);
        }
    }
}
