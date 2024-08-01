package acc.accountservice.applicant;

import com.TradeFinance.accountservice.account.Account;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="applicant_id")
       private Long applicantId;


    private String cifId;
    private String nationalId;
    private String accountName;
    private String accountNumber;
    private String address;
    private String postalCode;
    private String city;
    private String formattedAddress;
    private BigDecimal accountBalance;
    private String currency;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String countryCode;
    private String country;
    private String status;
    private String accountType;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Account account;


    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
    @LastModifiedBy
    private String updatedBy;
}


