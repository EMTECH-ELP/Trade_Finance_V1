package acc.accountservice.lookUp;

import com.TradeFinance.accountservice.lookUp.BankBicMapping;
import com.TradeFinance.accountservice.lookUp.BankBicMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBicLookUpService {
    @Autowired
    private BankBicMappingRepository bankBicMappingRepository;

//    public String getBankNameByBic(String bic) {
//        if (bic == null || bic.isEmpty()) {
//            throw new IllegalArgumentException("BIC is required");
//        }
//        BankBicMapping mapping = bankBicMappingRepository.findById(bic).orElse(null);
//        return mapping != null ? mapping.getBankName() : "Unknown Bank";
//    }

    public String getBankNameAndCountryByBic(String advisingBankBic) {
        if (advisingBankBic== null || advisingBankBic.isEmpty()) {
            throw new IllegalArgumentException("BIC is required");
        }
        BankBicMapping mapping = bankBicMappingRepository.findById(advisingBankBic).orElse(null);
        if (mapping != null) {
            return mapping.getBankName() + " - " + mapping.getCountry();
        } else {
            return "Unknown Bank - Unknown Country";
 }

}


}
