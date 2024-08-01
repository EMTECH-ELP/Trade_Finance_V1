package com.TradeLoans.InvoiceDiscounting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InvoiceDiscountingApplicationTests {

	@Test
	void contextLoads() {
	}

}

//@SpringBootTest
//public class InvoiceServiceTest {
//
//	@Mock
//	private InvoiceRepository invoiceRepository;
//
//	@InjectMocks
//	private InvoiceService invoiceService;
//
//	@Test
//	public void testCalculateFinancingAmount() {
//		// Mock invoice data
//		Invoice invoice = new Invoice();
//		invoice.setInvoiceAmount(BigDecimal.valueOf(1000));
//
//		// Define discount rate
//		BigDecimal discountRate = BigDecimal.valueOf(0.8);
//
//		// Calculate financing amount
//		BigDecimal expectedAmount = BigDecimal.valueOf(800);
//		BigDecimal actualAmount = invoiceService.calculateFinancingAmount(invoice.getId(), discountRate);
//
//		// Verify
//		assertEquals(expectedAmount, actualAmount);
//	}
//
//	// Write more tests for other methods like createInvoice, updateInvoice, etc.
//}


//@SpringBootTest
//@Transactional
//public class FundingServiceIntegrationTest {
//
//	@Autowired
//	private FundingService fundingService;
//
//	@Test
//	public void testDisburseFunds() {
//		// Create a sample invoice
//		Invoice invoice = new Invoice();
//		invoice.setInvoiceAmount(BigDecimal.valueOf(1000));
//		Invoice savedInvoice = invoiceRepository.save(invoice);
//
//		// Disburse funds
//		Funding funding = fundingService.disburseFunds(savedInvoice.getId(), BigDecimal.valueOf(800));
//
//		// Verify
//		assertNotNull(funding.getId());
//	}
//
//	// Write more integration tests for other methods like calculateFundingAmount, repayFunds, etc.
//}

////
//@SpringBootTest
//@Transactional
//public class PaymentServiceIntegrationTest {
//
//	@Autowired
//	private PaymentService paymentService;
//
//	@Test
//	public void testMakePayment() {
//		// Create a sample invoice
//		Invoice invoice = new Invoice();
//		invoice.setInvoiceAmount(BigDecimal.valueOf(1000));
//		Invoice savedInvoice = invoiceRepository.save(invoice);
//
//		// Make payment
//		paymentService.makePayment(savedInvoice.getId(), BigDecimal.valueOf(800));
//
//		// Verify
//		// You can add verification steps here if needed
//	}
//
//	// Write more integration tests for other payment methods and transaction management logic
//}