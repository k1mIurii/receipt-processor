package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class EveryTwoItemsCalculator implements PointCalculator {
    @Override
    public void calculate(Receipt receipt, Point point) {
        int pointsByPairs = receipt.getItems().size() / 2 * 5;
        point.setPoints(point.getPoints() + pointsByPairs);
    }
}
