package com.example.investhub.Controller;

import com.example.investhub.Model.Transaction;
import com.example.investhub.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @GetMapping("/investment/{investmentId}")
    public ResponseEntity<List<Transaction>> getTransactionsByInvestmentId(@PathVariable Long investmentId) {
        return ResponseEntity.ok(transactionService.getTransactionsByInvestmentId(investmentId));
    }

    // Other transaction-related endpoints
}
