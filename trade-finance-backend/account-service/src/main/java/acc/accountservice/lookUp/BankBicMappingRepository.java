package acc.accountservice.lookUp;

import com.TradeFinance.accountservice.lookUp.BankBicMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBicMappingRepository extends JpaRepository<com.TradeFinance.accountservice.lookUp.BankBicMapping, String> {
    BankBicMapping findByBic(String bic);
}
