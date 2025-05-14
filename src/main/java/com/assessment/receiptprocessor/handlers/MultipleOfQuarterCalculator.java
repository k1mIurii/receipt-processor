package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MultipleOfQuarterCalculator implements PointCalculator{
    @Override
    public void calculate(Receipt receipt, Point point) {
        BigDecimal total = new BigDecimal(receipt.getTotal());
        BigDecimal[] result = total.divideAndRemainder(new BigDecimal("0.25"));
        if (result[1].compareTo(BigDecimal.ZERO) == 0) {
            point.setPoints(point.getPoints() + 25);
        }
    }
}
