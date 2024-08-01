package acc.accountservice.countries;

import com.TradeFinance.accountservice.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface countryRepository extends JpaRepository<com.TradeFinance.accountservice.countries.Country,Long> {
    // In your countryRepository interface
    @Query("SELECT c FROM Country c WHERE c.countryName = :countryName")
    Optional<com.TradeFinance.accountservice.countries.Country> findByName(@Param("countryName") String countryName);

    Optional<com.TradeFinance.accountservice.countries.Country> findByCountryCode(String countryCode);

    Optional<Country> findByCountryCity(String countryCity);

//    void saveCountries(List<Country> countries);
}
