package acc.accountservice.emailAlerts;

import com.TradeFinance.accountservice.dto.EmailDto;
import com.TradeFinance.accountservice.emailAlerts.impl.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("{spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDto emailDto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDto.getRecipient());
            mailMessage.setText(emailDto.getMessageBody());
            mailMessage.setSubject(emailDto.getSubject());

            javaMailSender.send(mailMessage);
            System.out.println("Mail sent successfully");
        } catch (MailException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendEmailWithAttachment(EmailDto emailDto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(senderEmail);
            mimeMessageHelper.setTo(emailDto.getRecipient());
            mimeMessageHelper.setText(emailDto.getMessageBody());
            mimeMessageHelper.setSubject(emailDto.getSubject());

            FileSystemResource file = new FileSystemResource(new File(emailDto.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javaMailSender.send(mimeMessage);

            log.info(file.getFilename() + "has been sent to user with email  " + emailDto.getRecipient() );
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}

