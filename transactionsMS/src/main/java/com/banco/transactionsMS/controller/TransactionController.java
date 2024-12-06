package com.banco.transactionsMS.controller;

import com.banco.transactionsMS.model.Transaction;
import com.banco.transactionsMS.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Registra un depósito", description = "Realiza un depósito del sistema")
    @PostMapping("/deposit")
    public Mono<Transaction> deposit(@RequestBody Transaction transaction) {
        transaction.setType("Deposit");
        return transactionService.createTransaction(transaction);
    }

    @Operation(summary = "Registra un retiro", description = "Registra un retiro del sistema")
    @PostMapping("/withdrawal")
    public Mono<Transaction> withdrawal(@RequestBody Transaction transaction) {
        transaction.setType("Withdrawal");
        return transactionService.createTransaction(transaction);
    }

    @Operation(summary = "Registra una transferencia", description = "Registra una transferencia del sistema")
    @PostMapping("/transfer")
    public Mono<Transaction> transfer(@RequestBody Transaction transaction) {
        transaction.setType("Transfer");
        return transactionService.createTransaction(transaction);
    }

    @Operation(summary = "Lista todos las Transacciones", description = "Muestra todos los Transacciones del sistema")
    @GetMapping
    public Flux<Transaction> getAllTransactions() {
        return TransactionService.getAllTransactions();
    }

    @Operation(summary = "Busca una Transacción por ID", description = "Busca una Transacciónr del sistema por ID")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @GetMapping("/{id}")
    public Mono<Transaction> getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id);
    }


}
