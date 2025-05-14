package com.assessment.receiptprocessor.service;

import com.assessment.receiptprocessor.model.Receipt;

public interface ReceiptService {

    String process(Receipt receipt);

    String getPoints(String id);
}
