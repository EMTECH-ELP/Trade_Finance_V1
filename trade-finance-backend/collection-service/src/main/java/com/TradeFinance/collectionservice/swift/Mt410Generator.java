/*package com.TradeFinance.collectionservice.swift;

import com.TradeFinance.collectionservice.collection.dto.CollectionRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Mt410Generator implements SwiftMessageGenerator {



    @Override
    public String generateSwiftMessage(String messageType, Map<String, String> messageData) {
        CollectionRequest collectionRequest = CollectionRequest.builder().build();

        collectionRequest.setReferenceNumber(Long.valueOf(messageData.get("referenceNumber")));
        collectionRequest.setBillAmount(Float.parseFloat(messageData.get("billAmount")));
        collectionRequest.setCurrencyCode(messageData.get("currencyCode"));
        collectionRequest.setCollectionType(messageData.get("collectionType"));

        return generateSwiftMessage(collectionRequest);
    }

    private String generateSwiftMessage(CollectionRequest collectionRequest) {
        StringBuilder sb=new StringBuilder();
        sb.append("{1:O1BANKDEFOAXXX0000000000}{2:I410BANKDEFFXXXXN}{4:\n");
        sb.append(":20:").append(collectionRequest.getReferenceNumber()).append("\n");
        sb.append(":77A:").append(collectionRequest.getCollectionType()).append("\n");
        sb.append(":32A").append(collectionRequest.getBillAmount()).append("\n");
        return sb.toString();
    }
}*/
