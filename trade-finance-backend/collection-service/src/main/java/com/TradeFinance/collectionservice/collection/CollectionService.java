package com.TradeFinance.collectionservice.collection;

import com.TradeFinance.collectionservice.dto.AccountResponse;
import com.TradeFinance.collectionservice.dto.CollectionRequest;
import com.TradeFinance.collectionservice.util.ApiResponse;

public interface CollectionService {
    //AccountResponse getAccountDetailsByCifId(Long cifId);
   // ApiResponse<String> enterApplicantDetails(ApplicantDto applicantDto);
//ApiResponse<AccountResponse[]> getAccountDetailsByCifIdOrAccountNumberOrNationalId(String cifId, String accountNumber, String nationalId);
    ApiResponse<String> createCollection(CollectionRequest collectionRequest);
    ApiResponse<String> createCopy(Long collectionId);
    ApiResponse<Collection> modifyCollection(Long collectionId, CollectionRequest collectionRequest);
    ApiResponse<String> deleteCollection(Long collectionId);

}
   /* private CollectionRepository collectionRepository;

    public Collection createCollection(CollectionRequest collectionRequest) {
        Collection collection =createCollection(CollectionRequest.builder()
                .referenceNumber(collectionRequest.getReferenceNumber())
                .collectionType(collectionRequest.getCollectionType())
                .cifId(collectionRequest.getCifId())
                .currencyCode(collectionRequest.getCurrencyCode())
                .function(collectionRequest.getFunction())
                .acceptanceDate(collectionRequest.getAcceptanceDate())
                .goods(collectionRequest.getGoods())
                .shipment(collectionRequest.getShipment())
                .tenorType(collectionRequest.getTenorType())
                .protestDate(collectionRequest.getProtestDate())
                .billAmount(collectionRequest.getBillAmount())
                .build());
        collectionRepository.save(collection);
        return collection;

    }

    public Collection createCopy(Long existingReferenceNumber) {
        Collection existingCollection = collectionRepository.findByReferenceNumber(existingReferenceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Collection not found with referenceNumber:" + existingReferenceNumber));
        Collection copy = new Collection();
        copy.setCollectionType(existingCollection.getCollectionType());
        copy.setBillAmount(existingCollection.getBillAmount());
        copy.setCifId(existingCollection.getCifId());
        copy.setBillOutstandingAmount(existingCollection.getBillOutstandingAmount());
        copy.setCurrencyCode(existingCollection.getCurrencyCode());
        copy.setFunction(existingCollection.getFunction());
        copy.setFinanceAmount(existingCollection.getFinanceAmount());
        copy.setLocalCurrencyEquivalent(existingCollection.getLocalCurrencyEquivalent());
        copy.setAcceptanceDate(existingCollection.getAcceptanceDate());
        copy.setShipment(existingCollection.getShipment());
        copy.setTenorType(existingCollection.getTenorType());
        copy.setShipment(existingCollection.getShipment());
        copy.setGoods(existingCollection.getGoods());
        collectionRepository.save(copy);
        return copy;
    }
    public Collection modifyCollection(Long referenceNumber, CollectionRequest updateRequest) {
        Collection existingCollection = collectionRepository.findById(referenceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Collection not found with id: " + referenceNumber));

        // Update relevant fields from the request
        existingCollection.setCollectionType(updateRequest.getCollectionType()); // Adjust based on your needs
        existingCollection.setFunction(updateRequest.getFunction());
        existingCollection.setCollectionType(updateRequest.getCollectionType());
        existingCollection.setFunction(updateRequest.getFunction());
        existingCollection.setCurrencyCode(updateRequest.getCurrencyCode());

        return collectionRepository.save(existingCollection);
}
public void deleteCollection(Long referenceNumber){
       Collection collection= collectionRepository.findById(referenceNumber).orElseThrow(()->new ResourceNotFoundException("Collection not found with id:" + referenceNumber ));
        collectionRepository.deleteById(referenceNumber);
}

}*/


