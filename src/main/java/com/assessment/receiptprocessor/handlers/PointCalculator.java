package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;

public interface PointCalculator {

    void calculate(Receipt receipt, Point point);

}
