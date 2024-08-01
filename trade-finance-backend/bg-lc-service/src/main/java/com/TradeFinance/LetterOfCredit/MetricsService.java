package com.TradeFinance.LetterOfCredit;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class MetricsService {

    private final Counter successCounter;
    private final Counter failureCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        this.successCounter = Counter.builder("success.counter")
                .description("Counts successful operations")
                .register(meterRegistry);
        this.failureCounter = Counter.builder("failure.counter")
                .description("Counts failed operations")
                .register(meterRegistry);
    }

    public void incrementSuccessCounter() {
        successCounter.increment();
    }

    public void incrementFailureCounter() {
        failureCounter.increment();
    }
}