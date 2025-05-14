package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class AlphanumericalCalculator implements PointCalculator {

    @Override
    public void calculate(Receipt receipt, Point point) {
        String retailerName = receipt.getRetailer();
        for (int i = 0; i < retailerName.length(); i++) {
            if (Character.isLetterOrDigit(retailerName.charAt(i))) {
                point.setPoints(point.getPoints() + 1);
            }
        }
    }

}
