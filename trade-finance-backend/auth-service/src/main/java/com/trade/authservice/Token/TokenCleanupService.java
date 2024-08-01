package com.trade.authservice.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TokenCleanupService {
    @Autowired
    private TokenRepository tokenRepository;
    public TokenCleanupService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 5 * 1000)// Run every 5 minutes
    public void cleanUpExpiredTokens() {
        // Calculate the timestamp 10 minutes ago
        long currentTimeMillis = System.currentTimeMillis();
        Date fiveMinutesAgo = new Date(currentTimeMillis - (5 * 1000));

        // Delete tokens older than 10 minutes
        tokenRepository.deleteByExpirationDateBefore(fiveMinutesAgo);
    }
}

