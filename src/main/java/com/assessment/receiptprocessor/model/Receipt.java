package com.assessment.receiptprocessor.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class Receipt {

    private String retailer;

    private LocalDate purchaseDate;

    private LocalTime purchaseTime;

    private BigDecimal total;

    private List<Item> items;
}
