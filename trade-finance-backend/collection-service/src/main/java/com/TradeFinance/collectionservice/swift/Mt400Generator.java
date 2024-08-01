package com.TradeFinance.collectionservice.swift;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class Mt400Generator implements SwiftMessageGenerator {
    @Override
    public String generateSwiftMessage(String messageType, Map<String, String> messageData) {
        return null;
    }
}
