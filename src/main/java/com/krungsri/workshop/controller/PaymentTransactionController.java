package com.krungsri.workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentTransactionController {
    @GetMapping("/health-check")
    public String healthCheck() {
        return "UP";
    }
}
