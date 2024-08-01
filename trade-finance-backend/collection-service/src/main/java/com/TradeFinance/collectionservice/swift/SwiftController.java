package com.TradeFinance.collectionservice.swift;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/swift")
public class SwiftController {
    private final Map<String, SwiftMessageGenerator> messageGenerators;

    public SwiftController(Map<String, SwiftMessageGenerator> messageGenerators) {
        this.messageGenerators = messageGenerators;
    }

    @PostMapping("/{messageType}")
    public ResponseEntity<String> generateSwiftMessage(@PathVariable String messageType, @RequestBody Map<String, String> messageData) {
        SwiftMessageGenerator generator = messageGenerators.get(messageType);
        if (generator == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsupported message type: " + messageType);
        }

        String swiftMessage = generator.generateSwiftMessage(messageType, messageData);
        return ResponseEntity.ok(swiftMessage);
    }
}

