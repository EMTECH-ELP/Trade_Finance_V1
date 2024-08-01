package acc.accountservice.bank;

import com.TradeFinance.accountservice.bank.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/banks")
@CrossOrigin(origins = "*")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }

    @GetMapping("/{bankId}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long bankId) {
        Optional<Bank> bank = bankService.getBankById(bankId);
        return bank.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bank> saveBank(@RequestBody Bank bank) {
        Bank savedBank = bankService.saveBank(bank);
        return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
    }
    @PutMapping("/update/{bankId}")
    public ResponseEntity<Bank> updateBank(@PathVariable Long bankId, @RequestBody Bank bankDetails) {
        Bank updatedBank = bankService.updateBank(bankId, bankDetails);
        return updatedBank!= null? new ResponseEntity<>(updatedBank, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long Id) {
        bankService.deleteBank(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
//    @Autowired
//    private BankService bankService;
//
//    @GetMapping
//    public List<Bank> getAllBanks() {
//        return bankService.getAllBanks();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Bank> getBankById(@PathVariable Long id) {
//        return bankService.getBankById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//
//    }
//
//    @PostMapping
//    public Bank createBank(@RequestBody Bank bank) {
//
//        return bankService.saveBank(bank);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Bank> updateBank(@PathVariable Long id, @RequestBody Bank bankDetails) {
//        return ResponseEntity.ok(bankService.updateBank(id, bankDetails));
//    }
//    @DeleteMapping("/bank/{bankCode}")
//    public ResponseEntity<Void> deleteBankByCode(@PathVariable String bankCode) {
//        bankService.deleteBankByCode(bankCode);
//        return ResponseEntity.noContent().build();
//    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
//        bankService.deleteBank(id);
//        return ResponseEntity.noContent().build();
//    }
