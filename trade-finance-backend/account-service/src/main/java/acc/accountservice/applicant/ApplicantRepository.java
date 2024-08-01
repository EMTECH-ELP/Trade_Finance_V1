package acc.accountservice.applicant;

import com.TradeFinance.accountservice.account.AccountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    Boolean existsByEmail(String Email);
    Optional<Applicant> findByNationalId(String nationalId);

//    Optional<Applicant> findByCifId(String cifId);

    Boolean existsByAccountNumber(String accountNumber);
    Applicant findByAccountNumber(String accountNumber);
//    List<AccountProjection> findByCifIdOrAccountNumberOrNationalId(String cifId, String accountNumber, String nationalId);



}
