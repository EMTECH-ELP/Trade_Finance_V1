package acc.accountservice.account;

import com.TradeFinance.accountservice.applicant.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.cifId = :cifId OR a.accountNumber = :accountNumber OR a.nationalId = :nationalId")
    List<AccountProjection> findByCifIdOrAccountNumberOrNationalId(@Param("cifId") String cifId,
                                                         @Param("accountNumber") String accountNumber,
                                                         @Param("nationalId") String nationalId);

    Optional<Applicant> findByCifId(String cifId);
//    List<AccountProjection> findByCifIdOrAccountNumberOrNationalId(String cifId, String accountNumber, String nationalId);

}
