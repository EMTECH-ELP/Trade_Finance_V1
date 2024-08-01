package com.trade.authservice.checker;


import com.trade.authservice.utils.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("auth/checker/trade-finance")
public class CheckerController {

    @Autowired
    private CheckerService checkerService;

    @PostMapping("/approveLC")
    public EntityResponse<?> approveLC(@RequestParam Long lcId) {
        return checkerService.approveLC(lcId);
    }

    @PostMapping("/rejectLC")
    public EntityResponse<?> rejectLC(@RequestParam Long lcId) {
        return checkerService.rejectLC(lcId);
    }

    @PostMapping("/approveBill")
    public EntityResponse<?> approveBill(@RequestParam Long billId) {
        return checkerService.approveBill(billId);
    }

    @PostMapping("/rejectBill")
    public EntityResponse<?> rejectBill(@RequestParam Long billId) {
        return checkerService.rejectBill(billId);
    }

    @PostMapping("/approveBankGuarantee")
    public EntityResponse<?> approveBankGuarantee(@RequestParam Long bgId) {
        return checkerService.approveBankGuarantee(bgId);
    }

    @PostMapping("/rejectBankGuarantee")
    public EntityResponse<?> rejectBankGuarantee(@RequestParam Long bgId) {
        return checkerService.rejectBankGuarantee(bgId);
    }

    @PostMapping("/approveDocumentaryCollection")
    public EntityResponse<?> approveDocumentaryCollection(@RequestParam Long dcId) {
        return checkerService.approveDocumentaryCollection(dcId);
    }

    @PostMapping("/rejectDocumentaryCollection")
    public EntityResponse<?> rejectDocumentaryCollection(@RequestParam Long dcId) {
        return checkerService.rejectDocumentaryCollection(dcId);
    }

    @PostMapping("/approveInvoiceDiscounting")
    public EntityResponse<?> approveInvoiceDiscounting(@RequestParam Long idId) {
        return checkerService.approveInvoiceDiscounting(idId);
    }

    @PostMapping("/rejectInvoiceDiscounting")
    public EntityResponse<?> rejectInvoiceDiscounting(@RequestParam Long idId) {
        return checkerService.rejectInvoiceDiscounting(idId);
    }
}

