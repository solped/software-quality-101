package com.krungsri.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    int id;
    PaymentType type;
    TransactionStatus status;
    PaymentMethod method;
    double amount;
}
