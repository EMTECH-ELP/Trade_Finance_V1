package acc.accountservice.account;

import com.TradeFinance.accountservice.applicant.Applicant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{
    @Id
    @Column(name="applicant_id")
    private Long applicantId;

    private String cifId;

    @Column(nullable = false, updatable = false)
    private Long accountNumber;
    @Column (name = "account_name")
    private String accountName;

    @Column(name="account_type")
    private String accountType;
    @Column(nullable = false, updatable = false)
    private String nationalId;

    @Column(name="branch_address")
    private String branchAddress;
    @Column(name = "address")
    private String address;
    @Column (name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
//    private String formattedAddress;
//    private BigDecimal accountBalance;
@Column(name ="currency")
    private String currency;
    @Column(nullable = false,updatable = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "alternative_phone_number")
    private String alternativePhoneNumber;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country")
    private String country;
    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
//    @OneToOne()
//    @JoinColumn(name = "cif_id", referencedColumnName = "cif_id")
//    private Applicant applicant;
//    @OneToOne
//    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
//    private Bank bank;

}

