package acc.accountservice.beneficiary;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "beneficiary_details")

public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String beneficiaryFirstName;
    @Column(name = "middle_name",nullable = false)
    private String beneficiaryMiddleName;
    @Column(name = "last_name",nullable = false)
    private String beneficiaryLastName;
    @Column(name = "account_number",nullable = false)
    private String beneficiaryAccountNumber;
    @Column(name = "account_name")
    private String beneficiaryAccountName;
    @Column(name = "iban")
    private String beneficiaryIban;
    @Column(name = "beneficiary_email")
    private String beneficiaryEmail;
    @Column(name = "country_code")
    private String beneficiaryCountryCode;
    @Column(name = "country",nullable = false)
    private String beneficiaryCountry;
    @Column(name = "address_line_1", nullable = false)
    private String beneficiaryAddressLine1;
    @Column(name = "address_line_2")
    private String BankAddressLine2;
    @Column(name = "city", nullable = false)
    private String beneficiaryCity;
    @Column(name = "postal_code")
    private String beneficiaryPostalCode;
    @Column(name = "advising_bank_name",nullable = false)
    private String advisingBankName;
    @Column(name = "advising_bank_country",nullable = false)
    private String advisingBankCountry;
    @Column(name = "advising_bank_bic",nullable = false)
    private String advisingBankBic;
    @Column(name = "formatted_address", nullable = false)
    private String formattedAddress;
    public void setAccountNumber(String accountNumber) {
        this.beneficiaryAccountNumber = accountNumber;
        this.beneficiaryIban = null; // Reset IBAN if bankAccount number is provided
    }

    public void setIban(String iban) {
        this.beneficiaryIban = iban;
        this.beneficiaryAccountNumber = null; // Reset bankAccount number if IBAN is provided
    }

}



