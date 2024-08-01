package acc.accountservice.transaction.impl;

import com.TradeFinance.accountservice.dto.BankStatementDto;
//import com.TradeFinance.accountservice.transaction.Transaction;

public interface transactionService {
    void saveTransaction(BankStatementDto bankStatementDto);
}
