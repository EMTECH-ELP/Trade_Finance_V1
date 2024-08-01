//package com.TradeFinance.bankguarantee.controller;
//
//import com.TradeFinance.bg.entities.Document;
//import com.TradeFinance.bg.services.DocumentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/documents")
//public class DocumentController {
//
//    @Autowired
//    private DocumentService documentService;
//
//    @GetMapping
//    public ResponseEntity<List<Document>> getAllDocuments() {
//        List<Document> documents = documentService.getAllDocuments();
//        return new ResponseEntity<>(documents, HttpStatus.OK);
//    }
//
//
//}
//
