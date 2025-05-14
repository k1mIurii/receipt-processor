package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class RoundDollarCalculator implements PointCalculator {
    @Override
    public void calculate(Receipt receipt, Point point) {
        if (receipt.getTotal().stripTrailingZeros().scale() <= 0) {
            point.setPoints(point.getPoints() + 50);
        }
    }
}
