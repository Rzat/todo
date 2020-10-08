package com.example.todo.services.report;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseReportService {
    List findByShopName(String shopName, LocalDate from, LocalDate to, String type, String packagingType);
}
