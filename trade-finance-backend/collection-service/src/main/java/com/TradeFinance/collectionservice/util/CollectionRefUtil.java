package com.TradeFinance.collectionservice.util;

import java.time.LocalDateTime;
import java.util.Random;

public class CollectionRefUtil {
    public static String generateReferenceNumber(String collectionType) {
        String prefix = collectionType.equals("Import") ? "IC" : "EC";
        StringBuilder sb = new StringBuilder(prefix);
        // Generate 5 random alphanumeric characters
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) { // Randomly choose between alphabetic and numeric
                sb.append((char) (random.nextInt(26) + 'A')); // Alphabetic
            } else {
                sb.append(random.nextInt(10)); // Numeric
            }
        }
        // Append date and time of creation
        sb.append(LocalDateTime.now().toString());
        return sb.toString();
    }
}
