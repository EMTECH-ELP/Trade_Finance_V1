package com.TradeLoans.InvoiceDiscounting.controller;



import com.TradeLoans.InvoiceDiscounting.dtos.RepaymentDTO;
import com.TradeLoans.InvoiceDiscounting.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repayments")
@CrossOrigin("*")
public class RepaymentController {

    @Autowired
    private RepaymentService repaymentService;

    @GetMapping
    public List<RepaymentDTO> getAllRepayments() {
        return repaymentService.getAllRepayments();
    }

    @GetMapping("/{id}")
    public RepaymentDTO getRepaymentById(@PathVariable Long id) {
        return repaymentService.getRepaymentById(id);
    }

    @PostMapping
    public RepaymentDTO createRepayment(@RequestBody RepaymentDTO repaymentDTO) {
        return repaymentService.createRepayment(repaymentDTO);
    }

    @PutMapping("/{id}")
    public RepaymentDTO updateRepayment(@PathVariable Long id, @RequestBody RepaymentDTO repaymentDTO) {
        return repaymentService.updateRepayment(id, repaymentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRepayment(@PathVariable Long id) {
        repaymentService.deleteRepayment(id);
    }
}