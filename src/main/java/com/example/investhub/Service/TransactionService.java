package com.example.investhub.Service;

import com.example.investhub.Model.Transaction;
import com.example.investhub.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        // Add validation and business logic
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByInvestmentId(Long investmentId) {
        return transactionRepository.findByInvestmentId(investmentId);
    }

    // Other transaction-related methods
}
