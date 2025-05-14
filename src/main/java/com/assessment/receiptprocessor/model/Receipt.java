package com.assessment.receiptprocessor.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class Receipt {

    @NotNull
    @Pattern(regexp = "^[\\w\\s\\-&]+$")
    private String retailer;

    @NotNull
    private LocalDate purchaseDate;

    @NotNull
    private LocalTime purchaseTime;

    @NotNull
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String total;

    @NotNull
    private List<Item> items;
}
