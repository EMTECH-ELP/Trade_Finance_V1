//package com.TradeFinance.bankguarantee.swiftmessages.service;//package com.emt.TradeFinance.swiftmessages.service;
//
///*
// * *
// * Issue of a Demand Guarantee/Standby Letter of Credit
// * Issues or requests the issue of a guarantee or standby letter of credit
//*/
//
//import com.TradeFinance.bankguarantee.entity.BankGuarantee;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//
//public class    MT760Generator {
//    public static ByteArrayInputStream generatePdf(List<BankGuarantee> messages) {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try {
//            PdfWriter.getInstance(document, out);
//            document.open();
//
//            for (BankGuarantee message : messages) {
//                document.add(new Paragraph("Field1: " + message.getF()));
//                document.add(new Paragraph("Field2: " + message.getField2()));
//                document.add(new Paragraph("Field3: " + message.getField3()));
//                document.add(new Paragraph("\n"));
//            }
//
//            document.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//}
//
//
//
