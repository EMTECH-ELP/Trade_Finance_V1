//package com.TradeFinance.bankguarantee.swiftmessages.controller;//package com.emt.TradeFinance.swiftmessages.controller;
//
//import com.TradeFinance.bankguarantee.entity.BankGuarantee;
//import com.TradeFinance.bankguarantee.swiftmessages.service.MT760Generator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/messages")
//public class MT760Controller {
//    @Autowired
//    private MT760Generator messageService;
//
//    @GetMapping("/pdf")
//    public ResponseEntity<byte[]> getMessagesPdf() {
//        List<BankGuarantee> messages = messageService.getAllMessages();
//        ByteArrayInputStream bis = PdfGenerator.generatePdf(messages);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=messages.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
//                .body(bis.readAllBytes());
//    }
//}
