package acc.accountservice.beneficiary;

import com.TradeFinance.accountservice.beneficiary.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

}
