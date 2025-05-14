package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OddPurchaseDateCalculator implements PointCalculator{

    @Override
    public void calculate(Receipt receipt, Point point) {
        LocalDate purchaseDate = receipt.getPurchaseDate();
        if (purchaseDate.getDayOfMonth() % 2 == 1) {
            point.setPoints(point.getPoints() + 6);
        }
    }
}
