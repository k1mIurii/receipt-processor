package com.assessment.receiptprocessor.handlers;

import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class LLMGeneratedCalculator implements PointCalculator {
    @Override
    public void calculate(Receipt receipt, Point point) {
        
    }
}
