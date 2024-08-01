package acc.accountservice.chartOfAccounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chart_of_accounts")
public class ChartOfAccountsController {


        private final ChartOfAccountsService chartOfAccountsService;

        @Autowired
        public ChartOfAccountsController(ChartOfAccountsService chartOfAccountsService) {
            this.chartOfAccountsService = chartOfAccountsService;
        }

        @PostMapping
        public ResponseEntity<ChartOfAccounts> createAccount(@RequestBody AccountCreationDto creationDTO) {
            ChartOfAccounts account = chartOfAccountsService.addAccount(creationDTO);
            return ResponseEntity.ok(account);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ChartOfAccounts> updateAccount(@PathVariable Long id,
                                                             @RequestBody AccountUpdateDto updateDTO) {
            ChartOfAccounts account = chartOfAccountsService.updateAccount(updateDTO);
            return ResponseEntity.ok(account);
        }

        @GetMapping
        public ResponseEntity<List<ChartOfAccounts>> getAllAccounts() {
            List<ChartOfAccounts> accounts = chartOfAccountsService.getAllAccounts();
            return ResponseEntity.ok(accounts);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ChartOfAccounts> getAccountById(@PathVariable Long id) {
            ChartOfAccounts account = chartOfAccountsService.getAccountById(id);
            return ResponseEntity.ok(account);
        }
    }


