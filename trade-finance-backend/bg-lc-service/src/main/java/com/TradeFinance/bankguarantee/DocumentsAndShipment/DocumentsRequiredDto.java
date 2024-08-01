package com.TradeFinance.bankguarantee.DocumentsAndShipment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class DocumentsRequiredDto {

    @Schema(description = "Document Name", example = "Identity Proof")
    private String documentName1;

    @Schema(description = "Description of the first required document", example = "Valid passport, driver's license, or national ID card")
    private String documentDescription1;

    @Schema(description = "Document Name", example = "Proof of Address")
    private String documentName2;

    @Schema(description = "Description of the second required document", example = "Utility bill, bank statement, or government-issued document showing current address")
    private String documentDescription2;

    @Schema(description = "Document Name", example = "Financial Statement")
    private String documentName3;

    @Schema(description = "Description of the third required document", example = "Bank statement or tax return showing financial health and income")
    private String documentDescription3;

    @Schema(description = "Document Name", example = "Employment Letter")
    private String documentName4;

    @Schema(description = "Description of the fourth required document", example = "Letter from employer confirming employment status and salary")
    private String documentDescription4;

    @Schema(description = "Document Name", example = "Credit Report")
    private String documentName5;

    @Schema(description = "Description of the fifth required document", example = "Credit report from a credit bureau showing credit history")
    private String documentDescription5;

    @Schema(description = "Document Name", example = "Guarantee Application Form")
    private String documentName6;

    @Schema(description = "Description of the sixth required document", example = "Form filled out by the applicant detailing the guarantee request")
    private String documentDescription6;

    @Schema(description = "Document Name", example = "Bank Reference Letter")
    private String documentName7;

    @Schema(description = "Description of the seventh required document", example = "Letter from the bank confirming the applicant's account details and creditworthiness")
    private String documentDescription7;

    @Schema(description = "Document Name", example = "Legal Documentation")
    private String documentName8;

    @Schema(description = "Description of the eighth required document", example = "Contracts, agreements, or other legal documents related to the transaction")
    private String documentDescription8;

    @Schema(description = "Document Name", example = "Insurance Policy")
    private String documentName9;

    @Schema(description = "Description of the ninth required document", example = "Proof of insurance coverage for the transaction")
    private String documentDescription9;
}

