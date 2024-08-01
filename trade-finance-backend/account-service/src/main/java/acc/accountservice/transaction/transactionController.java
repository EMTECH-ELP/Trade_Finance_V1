package acc.accountservice.transaction;

import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
public class transactionController {

    private transactionService transactionService;
    @GetMapping
    public List<Transaction>generateBankStatement(@RequestParam String accountNumber,
                                                  @RequestParam String startDate,
                                                  @RequestParam String endDate) throws DocumentException, FileNotFoundException {
        return transactionService.generateStatement(accountNumber, startDate, endDate);

    }

}
