package com.TradeLoans.InvoiceDiscounting.service;

import com.TradeLoans.InvoiceDiscounting.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDataInitializer implements CommandLineRunner {

    @Autowired
    private CurrencyService currencyService;

    @Override
    public void run(String... args) throws Exception {
//        currencyService.saveCurrency(new Currency(null, "USD", "United States Dollar"));
//        currencyService.saveCurrency(new Currency(null, "EUR", "Euro"));
//        currencyService.saveCurrency(new Currency(null, "JPY", "Japanese Yen"));
//        currencyService.saveCurrency(new Currency(null, "GBP", "British Pound Sterling"));
//        currencyService.saveCurrency(new Currency(null, "AUD", "Australian Dollar"));
//        currencyService.saveCurrency(new Currency(null, "CAD", "Canadian Dollar"));
//        currencyService.saveCurrency(new Currency(null, "CHF", "Swiss Franc"));
//        currencyService.saveCurrency(new Currency(null, "CNY", "Chinese Yuan"));
//        currencyService.saveCurrency(new Currency(null, "SEK", "Swedish Krona"));
//        currencyService.saveCurrency(new Currency(null, "NZD", "New Zealand Dollar"));
//        currencyService.saveCurrency(new Currency(null, "MXN", "Mexican Peso"));
//        currencyService.saveCurrency(new Currency(null, "SGD", "Singapore Dollar"));
//        currencyService.saveCurrency(new Currency(null, "HKD", "Hong Kong Dollar"));
//        currencyService.saveCurrency(new Currency(null, "NOK", "Norwegian Krone"));
//        currencyService.saveCurrency(new Currency(null, "KRW", "South Korean Won"));
//        currencyService.saveCurrency(new Currency(null, "TRY", "Turkish Lira"));
//        currencyService.saveCurrency(new Currency(null, "RUB", "Russian Ruble"));
//        currencyService.saveCurrency(new Currency(null, "INR", "Indian Rupee"));
//        currencyService.saveCurrency(new Currency(null, "BRL", "Brazilian Real"));
    }

}