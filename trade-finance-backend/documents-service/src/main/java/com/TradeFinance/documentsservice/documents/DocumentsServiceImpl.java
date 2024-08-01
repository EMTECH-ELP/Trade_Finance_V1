package com.TradeFinance.documentsservice.documents;

import com.TradeFinance.documentsservice.util.DocumentsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentsServiceImpl implements DocumentsService{
    private final DocumentsRepository documentsRepository;
    @Override
    public String uploadDocument(String documentName,MultipartFile file) throws IOException {
        Documents documents = documentsRepository.save(Documents.builder()
                .documentName(documentName)
                .documentType(file.getContentType())
                .documents(DocumentsUtil.compressDocument(file.getBytes())).build());
        if (documents != null) {
            return "Document uploaded successfully:" + documentName;
        } else {
            return "Document not uploaded:" + documentName;

        }
    }
    public byte[] downloadDocument(Long documentId){
        Optional<Documents> dbDocument=documentsRepository.findById(documentId);
        if (dbDocument.isPresent()) {
            return DocumentsUtil.decompressDocument(dbDocument.get().getDocuments());
        } else {
            throw new RuntimeException("Document not found with ID: " + documentId);
        }
    }

}
