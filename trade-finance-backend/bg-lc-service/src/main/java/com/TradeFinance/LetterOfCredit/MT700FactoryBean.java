package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.dto.LetterOfCreditRequest;
import org.springframework.beans.factory.FactoryBean;

public class MT700FactoryBean implements FactoryBean<MT700> {
    @Override
    public MT700 getObject() throws Exception {
        LetterOfCreditRequest locRequest = new LetterOfCreditRequest(); // Initialize your request object here
        MT700 mt700 = new MT700(locRequest);
        return mt700;
    }

    @Override
    public Class<?> getObjectType() {
        return MT700.class;
    }

    @Override
    public boolean isSingleton() {
        return false; // Explicitly stating that this bean is not a singleton
    }
}
