package com.TradeLoans.InvoiceDiscounting.controller;


import com.TradeLoans.InvoiceDiscounting.model.Currency;
import com.TradeLoans.InvoiceDiscounting.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @PostMapping
    public Currency addCurrency(@RequestBody Currency currency) {
        return currencyService.saveCurrency(currency);
    }

    @GetMapping("/search")
    public List<Currency> searchCurrencies(@RequestParam String name) {
        return currencyService.searchCurrenciesByName(name);
    }
}
