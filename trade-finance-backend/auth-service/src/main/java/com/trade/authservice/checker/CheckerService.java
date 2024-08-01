package com.trade.authservice.checker;

import com.trade.authservice.tradeFinance.*;
import com.trade.authservice.utils.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckerService {

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

    public EntityResponse<?> approveLC(Long lcId) {
        return lcService.approveLC(lcId);
    }

    public EntityResponse<?> rejectLC(Long lcId) {
        return lcService.rejectLC(lcId);
    }

    public EntityResponse<?> approveBill(Long billId) {
        return billService.approveBill(billId);
    }

    public EntityResponse<?> rejectBill(Long billId) {
        return billService.rejectBill(billId);
    }

    public EntityResponse<?> approveBankGuarantee(Long bgId) {
        return bgService.approveBankGuarantee(bgId);
    }

    public EntityResponse<?> rejectBankGuarantee(Long bgId) {
        return bgService.rejectBankGuarantee(bgId);
    }

    public EntityResponse<?> approveDocumentaryCollection(Long dcId) {
        return dcService.approveDocumentaryCollection(dcId);
    }

    public EntityResponse<?> rejectDocumentaryCollection(Long dcId) {
        return dcService.rejectDocumentaryCollection(dcId);
    }

    public EntityResponse<?> approveInvoiceDiscounting(Long idId) {
        return idService.approveInvoiceDiscounting(idId);
    }

    public EntityResponse<?> rejectInvoiceDiscounting(Long idId) {
        return idService.rejectInvoiceDiscounting(idId);
    }
}
