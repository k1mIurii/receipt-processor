package com.assessment.receiptprocessor.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Item {

    private String shortDescription;

    private BigDecimal price;
}
