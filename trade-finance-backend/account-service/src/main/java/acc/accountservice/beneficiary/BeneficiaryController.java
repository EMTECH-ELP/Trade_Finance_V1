package acc.accountservice.beneficiary;

import com.TradeFinance.accountservice.beneficiary.BeneficiaryDto;
import com.TradeFinance.accountservice.beneficiary.BeneficiaryService;
import com.TradeFinance.accountservice.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/beneficiary")

public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;
    @PostMapping("/beneficiary-details")
    public ResponseEntity<?> enterBeneficiaryDetails(@RequestBody BeneficiaryDto beneficiaryDto) {
       return ResponseEntity.ok(beneficiaryService.enterBeneficiaryDetails(beneficiaryDto));
    }
    @PutMapping("/{beneficiaryId}")
    public ResponseEntity<ApiResponse<?>> modifyBeneficiaryDetails(@PathVariable Long beneficiaryId, @RequestBody BeneficiaryDto beneficiaryDto) {
        ApiResponse<?> response = beneficiaryService.modifyBeneficiaryDetails(beneficiaryId, beneficiaryDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}


