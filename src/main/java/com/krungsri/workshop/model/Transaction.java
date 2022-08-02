package com.krungsri.workshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    int id;
    PaymentType type;
    TransactionStatus status;
    PaymentMethod method;
    double amount;
}
