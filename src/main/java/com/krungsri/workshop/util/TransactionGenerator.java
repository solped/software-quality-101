package com.krungsri.workshop.util;

import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.model.PaymentType;
import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.model.TransactionStatus;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransactionGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static List<Transaction> generate(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> buildRandomizedTransaction())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static Transaction buildRandomizedTransaction() {
        return Transaction.builder()
                .status(randomEnum(TransactionStatus.class))
                .method(randomEnum(PaymentMethod.class))
                .type(randomEnum(PaymentType.class))
                .id(random.nextInt(2000))
                .amount(random.nextDouble() * 1000)
                .build();
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
