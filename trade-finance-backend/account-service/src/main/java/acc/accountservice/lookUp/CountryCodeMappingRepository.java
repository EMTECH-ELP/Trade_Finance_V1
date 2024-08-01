package acc.accountservice.lookUp;

import com.TradeFinance.accountservice.lookUp.CountryCodeMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCodeMappingRepository extends JpaRepository<com.TradeFinance.accountservice.lookUp.CountryCodeMapping, String> {
    CountryCodeMapping findByCountryCode(String countryCode);
}
