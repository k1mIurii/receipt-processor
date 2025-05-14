package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Item;
import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class TrimmedLengthCalculator implements PointCalculator {
    @Override
    public void calculate(Receipt receipt, Point point) {
        int total = 0;
        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                total += item.getPrice().multiply(new BigDecimal("0.2")).setScale(0, RoundingMode.UP).intValue();
            }
        }
        point.setPoints(point.getPoints() + total);
    }
}
