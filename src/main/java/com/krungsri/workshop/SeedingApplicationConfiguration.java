package com.krungsri.workshop;

import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.util.TransactionGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SeedingApplicationConfiguration {

    @Bean
    List<Transaction> initialTransaction() {
        return TransactionGenerator.generate(10);
    }
}
