package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.dto.LetterOfCreditRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MT700Configuration {
    @Bean
    public MT700FactoryBean mt700FactoryBean() {
        return new MT700FactoryBean();
    }

    @Bean
    public MT700 mt700(MT700FactoryBean mt700FactoryBean) throws Exception {
        return mt700FactoryBean.getObject();
    }

}
