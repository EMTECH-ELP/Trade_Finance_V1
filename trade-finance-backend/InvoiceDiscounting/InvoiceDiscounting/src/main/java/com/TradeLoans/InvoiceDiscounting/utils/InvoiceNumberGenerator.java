package com.TradeLoans.InvoiceDiscounting.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

@Component
public class InvoiceNumberGenerator {

    private static final Random RANDOM = new Random();

    public static String generate() {
        int randomSixDigit = 100000 + RANDOM.nextInt(900000); // Generates a random 6-digit number
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.format("INV-%06d-%d", randomSixDigit, currentYear);
    }
}
