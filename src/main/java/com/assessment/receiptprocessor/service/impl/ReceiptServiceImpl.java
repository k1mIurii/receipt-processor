package com.assessment.receiptprocessor.service.impl;

import com.assessment.receiptprocessor.handlers.PointCalculator;
import com.assessment.receiptprocessor.model.Point;
import com.assessment.receiptprocessor.model.Receipt;
import com.assessment.receiptprocessor.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private static final Map<String, Receipt> DATA = new HashMap<>();
    private static final String TEMPLATE  = """
            { "%s": %s }
            """;

    private final List<PointCalculator> calculators;

    @Override
    public String process(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        DATA.put(id, receipt);
        return String.format(TEMPLATE, "id", "\"" + id + "\"");
    }

    @Override
    public String getPoints(String id) {
        Receipt receipt = DATA.get(id);
        Point point = new Point(0);
        if (null != receipt) {
            calculators.forEach(calculator -> calculator.calculate(receipt, point));
        }
        return String.format(TEMPLATE, "points", point.getPoints());
    }
}
