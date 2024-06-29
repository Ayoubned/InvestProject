package com.example.investhub.Controller;

import com.example.investhub.Model.Investment;
import com.example.investhub.Service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
    @Autowired
    private InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        return ResponseEntity.ok(investmentService.createInvestment(investment));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<Investment>> getInvestmentsByPortfolioId(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(investmentService.getInvestmentsByPortfolioId(portfolioId));
    }

    // Other investment-related endpoints
}
