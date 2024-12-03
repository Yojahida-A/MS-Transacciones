package com.banco.transactionsMS;


import com.banco.transactionsMS.Repository.TransactionRepository;
import com.banco.transactionsMS.model.Transaction;

import com.banco.transactionsMS.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

//import static reactor.core.publisher.Mono.when;
import static org.mockito.Mockito.*;


public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setType("Deposit");
        transaction.setAmount(100.0);

        when(transactionRepository.save(transaction)).thenReturn(Mono.just(transaction));

        Mono<Transaction> result = transactionService.createTransaction(transaction);

        StepVerifier.create(result)
                .expectNextMatches(t -> t.getType().equals("Deposit") && t.getAmount() == 100.0)
                .verifyComplete();
    }

    @Test
    public void testGetAllTransactions() {
        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction();

        when(transactionRepository.findAll()).thenReturn(Flux.just(transaction1, transaction2));

        Flux<Transaction> result = TransactionService.getAllTransactions();

        StepVerifier.create(result)
                .expectNext(transaction1)
                .expectNext(transaction2)
                .verifyComplete();
    }



}
