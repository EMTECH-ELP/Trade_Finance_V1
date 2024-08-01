//package com.TradeFinance.LetterOfCredit.swift;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.prowidesoftware.swift.applicant.SwiftMessage;
//import com.prowidesoftware.swift.applicant.mt.mt7xx.MT700;
//import com.tradefinance.letterofcredit.GenerateMT700;
//
//public class MT700Service {
//    private GenerateMT700 generateMT700;
//    private Map<String, MT700> mt700DataStore = new HashMap<>();
//
//    // Create operation using the updated GenerateMT700 class
//    public void createMT700(String transactionReference, GenerateMT700 generateMT700) throws IOException {
//        MT700 mt700 = new MT700();
//        String swiftnetMessage = generateMT700.generateMT700Message();
//        mt700.setSwiftMessage(SwiftMessage.parse(swiftnetMessage));
//        mt700DataStore.put(transactionReference, mt700);
//    }
//
//    // Other CRUD operations...
//}
