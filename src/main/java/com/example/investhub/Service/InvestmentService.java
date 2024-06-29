package com.example.investhub.Service;

import com.example.investhub.Model.Investment;
import com.example.investhub.Repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {
    @Autowired
    private InvestmentRepository investmentRepository;

    public Investment createInvestment(Investment investment) {
        // Add validation and business logic
        return investmentRepository.save(investment);
    }

    public List<Investment> getInvestmentsByPortfolioId(Long portfolioId) {
        return investmentRepository.findByPortfolioId(portfolioId);
    }

    // Other investment-related methods
}
