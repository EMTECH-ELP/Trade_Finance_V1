package acc.accountservice.transaction;

import com.TradeFinance.accountservice.applicant.Applicant;
import com.TradeFinance.accountservice.applicant.ApplicantRepository;
import com.TradeFinance.accountservice.dto.EmailDto;
import com.TradeFinance.accountservice.emailAlerts.impl.EmailService;
import com.itextpdf.text.*;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j

public class transactionService {
    private transactionRepository transactionRepository;
    private ApplicantRepository applicantRepository;
    private EmailService emailService;
    private static final String FILE="C:\\Users\\user\\Documents\\MyStatement.pdf";

    /**
     * retrieve list of transactions within  a date range given an account number
     * generate a pdf file of transactions
     * send file via email
     */
    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate) throws FileNotFoundException, DocumentException {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);
        List<Transaction> transactionList = transactionRepository.findAll().stream().filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .filter(transaction -> transaction.getCreatedAt().isEqual(start)).filter(transaction -> transaction.getCreatedAt().isEqual(end)).toList();

        Applicant applicant = applicantRepository.findByAccountNumber(accountNumber);
        String customerName = applicant.getAccountName();

        Rectangle statementSize = new Rectangle(PageSize.A4);
        Document document = new Document(statementSize);
        log.info("setting size of document");
        OutputStream outputStream = new FileOutputStream(FILE);
        PdfWriter.getInstance(document,outputStream);
        document.open();

        PdfPTable bankInfoTable = new PdfPTable(1);
        PdfPCell bankName= new PdfPCell(new Phrase("Your Bank Statement"));
        bankName.setBorder(0);
        bankName.setBackgroundColor(BaseColor.LIGHT_GRAY);
        bankName.setPadding(20f);
        PdfPCell bankAddress = new PdfPCell(new Phrase(" Nairobi, Kenya"));
        bankAddress.setBorder(0);
        bankInfoTable.addCell(bankName);
        bankInfoTable.addCell(bankAddress);

        PdfPTable statementInfo = new PdfPTable(2);
        PdfPCell customerInfo = new PdfPCell(new Phrase("StartDate:  " + startDate));
        customerInfo.setBorder(0);
        PdfPCell statement = new PdfPCell(new Phrase("STATEMENT OF ACCOUNT"));
        statement.setBorder(0);
        PdfPCell stopDate = new PdfPCell(new Phrase("EndDate:  "+ endDate));
        stopDate.setBorder(0);
        PdfPCell name = new PdfPCell(new Phrase("Customer Name:  " + customerName));
        name.setBorder(0);
        PdfPCell space = new PdfPCell();
        PdfPCell address = new PdfPCell(new Phrase("Customer Address:  " + applicant.getAddress()));
        address.setBorder(2);






        PdfPTable transactionTable = new PdfPTable(5);
        PdfPCell date = new PdfPCell(new Phrase("Date"));
        date.setBackgroundColor(BaseColor.LIGHT_GRAY);
        date.setBorder(0);

        PdfPCell transactionType = new PdfPCell(new Phrase("Transaction type"));
        transactionType.setBackgroundColor(BaseColor.LIGHT_GRAY);
        transactionType.setBorder(0);

        PdfPCell transactionAmount = new PdfPCell(new Phrase("Transaction amount"));
        transactionType.setBackgroundColor(BaseColor.LIGHT_GRAY);
        transactionType.setBorder(0);

        PdfPCell status = new PdfPCell(new Phrase("Status "));
        transactionType.setBackgroundColor(BaseColor.LIGHT_GRAY);
        transactionType.setBorder(0);

        transactionTable.addCell(date);
        transactionTable.addCell(transactionType);
        transactionTable.addCell(transactionAmount);
        transactionTable.addCell(status);


        transactionList.forEach(transaction -> {
            transactionTable.addCell(new Phrase(transaction.getCreatedAt().toString()));
            transactionTable.addCell(new Phrase(transaction.getTransactionType()));
            transactionTable.addCell(new Phrase(transaction.getAmount().toString()));
            transactionTable.addCell(new Phrase(transaction.getStatus()));
        });


        statementInfo.addCell(customerInfo);
        statementInfo.addCell(statement);
        statementInfo.addCell(endDate);
        statementInfo.addCell(name);
        statementInfo.addCell(space);
        statementInfo.addCell(address);

        document.add(bankInfoTable);
        document.add(statementInfo);
        document.add(transactionTable);
        document.close();

        EmailDto emailDto = EmailDto.builder()
                .recipient(applicant.getEmail())
                .subject("ACCOUNT STATEMENT")
                .messageBody("Kindly find attached your account statement")
                .attachment(FILE)
                .build();

        emailService.sendEmailWithAttachment(emailDto);




        return transactionList;


    }
}









