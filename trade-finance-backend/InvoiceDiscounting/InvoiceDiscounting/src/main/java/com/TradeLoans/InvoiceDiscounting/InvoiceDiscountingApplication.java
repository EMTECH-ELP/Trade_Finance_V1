package com.TradeLoans.InvoiceDiscounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableDiscoveryClient
public class InvoiceDiscountingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceDiscountingApplication.class, args);
	}

}
/////
//
//One customer can have multiple invoices
//Each invoice belongs to one customer
//Each invoice can have multiple fundings
//Each funding belongs to one invoice
