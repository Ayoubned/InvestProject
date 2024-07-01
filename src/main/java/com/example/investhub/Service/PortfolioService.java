package com.example.investhub.Service;

import com.example.investhub.Model.Investment;
import com.example.investhub.Model.Portfolio;
import com.example.investhub.Model.PortfolioPerformance;
import com.example.investhub.Repository.InvestmentRepository;
import com.example.investhub.Repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private InvestmentRepository investmentRepository;

    public Portfolio createPortfolio(Portfolio portfolio) {
        // Add validation and business logic
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getPortfoliosByUserId(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }

    public Portfolio getPortfolioById(Long portfolioId) {
        return portfolioRepository.findById(portfolioId).get();
    }

    public PortfolioPerformance calculatePortfolioPerformance(Long portfolioId) {
        Portfolio portfolio = getPortfolioById(portfolioId);
        List<Investment> investments = investmentRepository.findByPortfolioId(portfolioId);

        BigDecimal totalValue = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Investment investment : investments) {
            totalValue = totalValue.add(investment.getCurrentValue());
            totalCost = totalCost.add(investment.getPurchasePrice());
        }

        BigDecimal performancePercentage = totalCost.compareTo(BigDecimal.ZERO) != 0
                ? totalValue.subtract(totalCost)
                .divide(totalCost, 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"))
                : BigDecimal.ZERO;

        return new PortfolioPerformance(
                portfolio.getId(),
                portfolio.getName(),
                totalValue,
                totalCost,
                performancePercentage
        );
    }

    // Other portfolio-related methods
}
