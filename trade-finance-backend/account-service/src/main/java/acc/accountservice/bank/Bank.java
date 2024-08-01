package acc.accountservice.bank;

import com.TradeFinance.accountservice.account.Account;
import com.TradeFinance.accountservice.applicant.Applicant;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Banks")

public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long bankId;

    private String bankName;
    private String bankCountry;
    private String bankSwiftCode;
    private String bankCode;
    private String branchCode;
    private String branchName;


//    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
//    private List<Branches> branches;





}

