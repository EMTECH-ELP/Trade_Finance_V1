//package com.TradeFinance.configuration;
//
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.prometheus.PrometheusMeterRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ActuatorConfiguration {
//
//    @Bean
//    public PrometheusMeterRegistry prometheusMeterRegistry(MeterRegistry meterRegistry) {
//        return new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
//    }
//
//    // This method is optional and might not be necessary for your setup.
//    // It's included here as an example of how you might customize the PrometheusMeterRegistry.
//    @Bean
//    public PrometheusMeterRegistryCustomizer prometheusMeterRegistryCustomizer() {
//        return registry -> {
//            registry.config().commonTags("application", "my-application");
//
//            // Example: Apply a filter to modify metrics
//            registry.config().meterFilter(MeterFilter.denyNameStartsWith("jvm_threads"));
//        };
//    }
//}
