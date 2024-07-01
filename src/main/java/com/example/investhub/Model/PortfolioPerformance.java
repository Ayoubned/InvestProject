package com.example.investhub.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class PortfolioPerformance {

    // Getters and setters
    private Long portfolioId;
    private String portfolioName;
    private BigDecimal totalValue;
    private BigDecimal totalCost;
    private BigDecimal performancePercentage;
    private BigDecimal profitLoss;
    private LocalDateTime calculationTime;

    // Constructor
    public PortfolioPerformance(Long portfolioId, String portfolioName, BigDecimal totalValue,
                                BigDecimal totalCost, BigDecimal performancePercentage) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.totalValue = totalValue;
        this.totalCost = totalCost;
        this.performancePercentage = performancePercentage;
        this.profitLoss = totalValue.subtract(totalCost);
        this.calculationTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PortfolioPerformance{" +
                "portfolioId=" + portfolioId +
                ", portfolioName='" + portfolioName + '\'' +
                ", totalValue=" + totalValue +
                ", totalCost=" + totalCost +
                ", performancePercentage=" + performancePercentage +
                ", profitLoss=" + profitLoss +
                ", calculationTime=" + calculationTime +
                '}';
    }
}
