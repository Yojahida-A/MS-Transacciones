//package com.banco.transactionsMS;

import com.banco.transactionsMS.controller.TransactionController;
import com.banco.transactionsMS.model.Transaction;
import com.banco.transactionsMS.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

//
//@SpringBootTest
//public class TransactionControllerTest {


//    @MockBean
//    private TransactionService transactionService;
//
//    @InjectMocks
//    private TransactionController transactionController;
//
//    private WebTestClient webTestClient;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        webTestClient = WebTestClient.bindToController(transactionController).build();
//    }
//
//    @Test
//    public void testDeposit() {
//        Transaction transaction = new Transaction();
//        transaction.setType("Deposit");
//        transaction.setAmount(100.0);
//
//        when(transactionService.createTransaction(any(Transaction.class))).thenReturn(Mono.just(transaction));
//
//        webTestClient.post()
//                .uri("/transactions/deposit")
//                .bodyValue(transaction)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Transaction.class)
//                .value(response -> {
//                    assert response.getType().equals("Deposit");
//                    assert response.getAmount() == 100.0;
//                });
//    }


//}
