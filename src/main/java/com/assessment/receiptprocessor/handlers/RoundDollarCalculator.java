package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RoundDollarCalculator implements PointCalculator {
    @Override
    public void calculate(Receipt receipt, Point point) {
        BigDecimal total = new BigDecimal(receipt.getTotal());
        if (total.stripTrailingZeros().scale() <= 0) {
            point.setPoints(point.getPoints() + 50);
        }
    }
}
