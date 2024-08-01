package com.trade.authservice.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDatabaseConfig {
    @Value("${spring.datasource.password}")
    private String databasePassword;

}