package acc.accountservice.bank;

import com.TradeFinance.accountservice.bank.Bank;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService  {

    @Autowired
    private BankRepository bankRepository;

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getBankById(Long bankId) {
        return bankRepository.findById(bankId);
    }

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public void deleteBank(Long bankId) {
        bankRepository.deleteById(bankId);
    }

    public Bank updateBank(Long bankId, Bank bankDetails) {
        return bankRepository.findById(bankId)
                .map(bank -> {
                    bank.setBankName(bankDetails.getBankName());
                    bank.setBankCode(bankDetails.getBankCode());
                    bank.setBankCountry(bankDetails.getBankCountry());
                    bank.setBankSwiftCode(bankDetails.getBankSwiftCode());


                    return bankRepository.save(bank);
                })
                .orElse(null); // Return null if bank not found
    }
}




