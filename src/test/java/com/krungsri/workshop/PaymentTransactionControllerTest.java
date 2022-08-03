package com.krungsri.workshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.model.PaymentType;
import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.model.TransactionStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SoftwareQualityApplication.class
)
class PaymentTransactionControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void givenGetTransactionCall_shouldReturnAllTransaction() throws JsonProcessingException {
        // given

        // when
        ResponseEntity<String> response = testRestTemplate.getForEntity("/transactions", String.class);

        // then
        List<Transaction> transactions = objectMapper.readValue(response.getBody(), new TypeReference<List<Transaction>>() {
        });
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(transactions.size()).isEqualTo(5);
    }

    @Test
    void givenValidTransactions_whenCallProcessTransaction_shouldReturnSuccess() {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(
                Transaction.builder()
                        .id(1)
                        .status(TransactionStatus.OPEN)
                        .type(PaymentType.PAYMENT)
                        .method(PaymentMethod.PAYPAL)
                        .amount(100.00)
                        .build()
        );
        transactions.add(
                Transaction.builder()
                        .id(2)
                        .status(TransactionStatus.OPEN)
                        .type(PaymentType.REFUND)
                        .method(PaymentMethod.CREDIT_CARD)
                        .amount(200.00)
                        .build()
        );

        // when
        ResponseEntity<String> response = testRestTemplate.postForEntity("/transactions", transactions, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void givenClosedTransaction_whenCallProcessTransaction_shouldReturnSuccess() {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(
                Transaction.builder()
                        .id(1)
                        .status(TransactionStatus.CLOSED)
                        .type(PaymentType.PAYMENT)
                        .method(PaymentMethod.PAYPAL)
                        .amount(100.00)
                        .build()
        );

        // when
        ResponseEntity<String> response = testRestTemplate.postForEntity("/transactions", transactions, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void givenInvalidPaymentType_whenCallProcessTransaction_shouldReturnError() {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(
                Transaction.builder()
                        .id(1)
                        .status(TransactionStatus.OPEN)
                        .type(PaymentType.PAYMENT)
                        .method(PaymentMethod.PAYPAL)
                        .amount(100.00)
                        .build()
        );
        transactions.add(
                Transaction.builder()
                        .id(2)
                        .status(TransactionStatus.OPEN)
                        .type(PaymentType.INVALID)
                        .method(PaymentMethod.CREDIT_CARD)
                        .amount(200.00)
                        .build()
        );

        // when
        ResponseEntity<String> response = testRestTemplate.postForEntity("/transactions", transactions, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void givenNotSupportPaymentMethod_whenCallProcessTransaction_shouldReturnError() {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(
                Transaction.builder()
                        .id(1)
                        .status(TransactionStatus.OPEN)
                        .type(PaymentType.PAYMENT)
                        .method(PaymentMethod.PAYPAL)
                        .amount(100.00)
                        .build()
        );
        transactions.add(
                Transaction.builder()
                        .id(2)
                        .status(TransactionStatus.OPEN)
                        .type(PaymentType.REFUND)
                        .method(PaymentMethod.NOT_SUPPORT)
                        .amount(200.00)
                        .build()
        );

        // when
        ResponseEntity<String> response = testRestTemplate.postForEntity("/transactions", transactions, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}