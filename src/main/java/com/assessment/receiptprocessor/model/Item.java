package com.assessment.receiptprocessor.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    @NotNull
    @Pattern(regexp = "^[\\w\\s\\-]+$")
    private String shortDescription;

    @NotNull
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String price;
}
