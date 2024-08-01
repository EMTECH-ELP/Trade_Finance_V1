package com.trade.authservice.maker;

import com.trade.authservice.tradeFinance.*;
import com.trade.authservice.utils.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("auth/maker/trade-finance")
public class MakerController {

    @Autowired
    private LetterOfCreditService lcService;

    @Autowired
    private BillService billService;

    @Autowired
    private BankGuaranteeService bgService;

    @Autowired
    private DocumentaryCollectionService dcService;

    @Autowired
    private InvoiceDiscountingService idService;

    @PostMapping("/createLC")
    public EntityResponse<?> createLC(@RequestBody LCCreationRequest request) {
        return lcService.createLC(request);
    }

    @PostMapping("/createBill")
    public EntityResponse<?> createBill(@RequestBody BillCreationRequest request) {
        return billService.createBill(request);
    }

    @PostMapping("/createBankGuarantee")
    public EntityResponse<?> createBankGuarantee(@RequestBody BGCreationRequest request) {
        return bgService.createBankGuarantee(request);
    }

    @PostMapping("/createDocumentaryCollection")
    public EntityResponse<?> createDocumentaryCollection(@RequestBody DCCreationRequest request) {
        return dcService.createDocumentaryCollection(request);
    }

    @PostMapping("/createInvoiceDiscounting")
    public EntityResponse<?> createInvoiceDiscounting(@RequestBody IDCreationRequest request) {
        return idService.createInvoiceDiscounting(request);
    }

    // Additional methods for updating, deleting, or retrieving trade finance tools can be added here based on requirements.
}
