package acc.accountservice.emailAlerts.impl;

import com.TradeFinance.accountservice.dto.EmailDto;

public interface EmailService {
    void sendEmailAlert(EmailDto emailDto);

    void sendEmailWithAttachment(EmailDto emailDto);
}
