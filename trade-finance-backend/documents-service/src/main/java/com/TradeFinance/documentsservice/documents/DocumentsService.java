package com.TradeFinance.documentsservice.documents;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentsService {
    String uploadDocument(String documentName,MultipartFile file) throws IOException;
    byte[] downloadDocument(Long documentId);
}
