package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class MidAfternoonPurchaseTimeCalculator implements PointCalculator {
    @Override
    public void calculate(Receipt receipt, Point point) {
        LocalTime purchaseTime = receipt.getPurchaseTime();
        if (purchaseTime.isAfter(LocalTime.of(14, 0))
                && purchaseTime.isBefore(LocalTime.of(16, 0))) {
            point.setPoints(point.getPoints() + 10);
        }
    }
}
