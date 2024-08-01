package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.dto.LetterOfCreditRequest;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Scope("prototype")
@Component
public class MT700 extends AbstractMT implements MT700Interface {

    private LetterOfCreditRequest letterOfCreditRequest;
    private List<Field> addedFields = new ArrayList<>();
    private boolean isInitialized = false; // Flag to track initialization status

    public MT700(List<Field> initialFields) {
        super((SwiftMessage) initialFields);
        this.addedFields.addAll(initialFields);
    }

    public MT700(LetterOfCreditRequest letterOfCreditRequest) {
        this.letterOfCreditRequest = letterOfCreditRequest;
    }

    public void setLocRequest(LetterOfCreditRequest locRequest) {
        if (isInitialized) {
            // Optionally log a warning or throw an exception here if needed
            System.out.println("MT700 is already initialized. Not overwriting existing data.");
            return;
        }

        resetState();
        setSender(locRequest.getApplicantDto().getAccountNumber());
        setReceiver(locRequest.getBeneficiaryDto().getAdvisingBankBic());
        addField(new Field40A(locRequest.getLcType()));
        addField(new Field20(locRequest.getLcNumber()));
        addField(new Field23(locRequest.getAdvise()));
        addField(new Field31C(String.valueOf(locRequest.getIssueDate())));
        addField(new Field40E(locRequest.getApplicableRules()));
        addField(new Field31D(String.valueOf(locRequest.getExpiryDate())));
        addField(new Field51A(locRequest.getApplicantDto().getApplicantSwiftCode()));
        addField(new Field50(locRequest.getApplicantDto().getAccountName()));
        addField(new Field32A(String.valueOf(locRequest.getExpiryDate())));
        addField(new Field50A(locRequest.getApplicantDto().getAccountNumber()));
        addField(new Field59(locRequest.getBeneficiaryDto().getBeneficiaryAccountName()));
        String combinedInfo = String.format("%s %s", locRequest.getAmount(), locRequest.getCurrencyCode());
        addField(new Field32B(combinedInfo));
        addField(new Field42C(locRequest.getTenor()));
        addField(new Field42P(String.valueOf(locRequest.getNegotiationPeriod())));
        addField(new Field43P(locRequest.getShipmentAndGoodsDto().getPartialShipment()));
        addField(new Field43T(locRequest.getShipmentAndGoodsDto().getTransShipment()));
        addField(new Field44E(locRequest.getShipmentAndGoodsDto().getPortOfLoading()));
        addField(new Field44F(locRequest.getShipmentAndGoodsDto().getPortOfDischarge()));
        addField(new Field44C(String.valueOf(locRequest.getShipmentAndGoodsDto().getShipmentDate())));
        addField(new Field45A(locRequest.getShipmentAndGoodsDto().getCommodityCode()));
        String documentInfo = String.format("%s %s", locRequest.getDocumentsRequiredDto().getDocumentName1(), locRequest.getDocumentsRequiredDto().getDocumentDescription1());
        addField(new Field32B(documentInfo));
        addField(new Field71D(locRequest.getChargesBorneBy()));
        addField(new Field48(locRequest.getConfirm()));
        addField(new Field14B(locRequest.getApplicableRules()));
        addField(new Field44F(locRequest.getTenor()));

        isInitialized = true; // Mark as initialized after setting up
    }

    void resetState() {
        setSender((String) null);
        setReceiver((String) null);
        removeAllFields();
    }

    private void removeAllFields() {
        addedFields.clear();
    }

    public void addField(Field field) {
        super.addField(field);
        addedFields.add(field);
    }

    @Override
    public String getMessageType() {
        return "MT700";
    }
}
