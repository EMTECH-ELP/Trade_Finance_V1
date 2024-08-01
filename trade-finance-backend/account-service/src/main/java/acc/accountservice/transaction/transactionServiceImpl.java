package acc.accountservice.transaction;

import com.TradeFinance.accountservice.dto.BankStatementDto;
import com.TradeFinance.accountservice.transaction.impl.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class transactionServiceImpl implements transactionService {
    @Autowired
    transactionRepository transactionRepository;

    @Override
    public void saveTransaction(BankStatementDto bankStatementDto) {
        Transaction transaction = Transaction.builder()
                .transactionType(bankStatementDto.getTransactionType())
                .accountNumber(bankStatementDto.getAccountNumber())
                .amount(bankStatementDto.getAmount())
                .status("SUCCESS")
                .build();
        transactionRepository.save(transaction);
        System.out.println("Transaction saved successfully");

    }
}
