package com.TradeLoans.InvoiceDiscounting.service;

import com.TradeLoans.InvoiceDiscounting.model.Currency;
import com.TradeLoans.InvoiceDiscounting.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    public List<Currency> searchCurrenciesByName(String name) {
        return currencyRepository.findByNameContainingIgnoreCase(name);
    }

    public Currency updateCurrency(Long id, Currency currencyDetails) {
        Currency currency = currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        currency.setCode(currencyDetails.getCode());
        currency.setName(currencyDetails.getName());

        return currencyRepository.save(currency);
    }

    public void deleteCurrency(Long id) {
        Currency currency = currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        currencyRepository.delete(currency);
    }

    public Currency getCurrencyById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));
    }


}
