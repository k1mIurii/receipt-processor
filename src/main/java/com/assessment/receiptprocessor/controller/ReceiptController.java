package com.assessment.receiptprocessor.controller;

import com.assessment.receiptprocessor.model.Receipt;
import com.assessment.receiptprocessor.service.ReceiptService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping(path = "/process")
    public ResponseEntity<String> process(@Valid @RequestBody Receipt receipt) {
        return new ResponseEntity<>(receiptService.process(receipt), HttpStatus.OK);
    }


    @GetMapping(path = "/{id}/points")
    public ResponseEntity<String> getPoints(@PathVariable String id) {
        return new ResponseEntity<>(receiptService.getPoints(id), HttpStatus.OK);
    }
}
