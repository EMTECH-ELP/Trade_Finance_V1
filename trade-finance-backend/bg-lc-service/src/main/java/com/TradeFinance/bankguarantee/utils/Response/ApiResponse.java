package com.TradeFinance.bankguarantee.utils.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse<T> {
    public String message;
    public T entity; //{}
    public Integer statusCode; //201

    public String setMessage(String message) {
        return this.message;
    }

    public Integer setStatusCode(int statusCode) {
        return this.statusCode;
    }

}