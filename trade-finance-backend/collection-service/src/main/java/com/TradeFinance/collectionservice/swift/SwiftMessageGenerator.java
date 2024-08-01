package com.TradeFinance.collectionservice.swift;

import java.util.Map;

public interface SwiftMessageGenerator {
    public String generateSwiftMessage (String messageType, Map<String, String> messageData);
}
