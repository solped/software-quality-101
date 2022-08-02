package com.krungsri.workshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcessedTransactionResult {
    double creditCard;
    double paypal;
    double plan;
}
