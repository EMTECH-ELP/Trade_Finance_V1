package com.TradeFinance.documentsservice.documents;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/document")
@RequiredArgsConstructor
public class DocumentsController {
    private final DocumentsService documentsService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("documentName")String documentName, MultipartFile file) {
        try {
            String message = documentsService.uploadDocument(documentName, file);
            return ResponseEntity.ok(message);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading document");
        }

    }
    @GetMapping("/{documentId}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long documentId) {
        byte[] document = documentsService.downloadDocument(documentId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "document.pdf");
        headers.setContentLength(document.length);
        return new ResponseEntity<>(document, headers, HttpStatus.OK);
    }
}
