package com.trade.authservice.tradeFinance;

import com.trade.authservice.utils.EntityResponse;
import org.springframework.stereotype.Service;

@Service
public class DocumentaryCollectionService {

    public EntityResponse<?> createDocumentaryCollection(DCCreationRequest request) {
        // Business logic to create Documentary Collection
        // Assuming statusCode, entity, and qrCodeImage are null for now
        return new EntityResponse<>("Documentary Collection created successfully", null, null, null);
    }

    public EntityResponse<?> approveDocumentaryCollection(Long dcId) {
        return new EntityResponse<>("Documentary colection approved", null);
    }

    public EntityResponse<?> rejectDocumentaryCollection(Long dcId) {
        return new EntityResponse<>("Documentary collection creation rejected",null);
    }

    // Other methods related to Documentary Collection functionality
}
