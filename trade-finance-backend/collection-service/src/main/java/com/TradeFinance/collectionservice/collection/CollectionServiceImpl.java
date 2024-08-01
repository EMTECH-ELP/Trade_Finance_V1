package com.TradeFinance.collectionservice.collection;


import com.TradeFinance.collectionservice.dto.AccountResponse;
import com.TradeFinance.collectionservice.dto.CollectionRequest;
import com.TradeFinance.collectionservice.feign.AccountInterface;
import com.TradeFinance.collectionservice.goodsAndShipment.Good;
import com.TradeFinance.collectionservice.goodsAndShipment.Shipment;
import com.TradeFinance.collectionservice.tenor.ProtestDetails;
import com.TradeFinance.collectionservice.tenor.TenorDetails;
import com.TradeFinance.collectionservice.tracer.TracerDetails;
import com.TradeFinance.collectionservice.util.ApiResponse;
import com.TradeFinance.collectionservice.util.CollectionRefUtil;
import com.TradeFinance.collectionservice.util.CollectionServiceUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.TradeFinance.collectionservice.util.CollectionServiceUtil.mapToGood;
import static com.TradeFinance.collectionservice.util.CollectionServiceUtil.mapToShipment;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository collectionRepository;
    //private final WebClient webClient;
    private final AccountInterface accountInterface;


    @Override
    public ApiResponse<String> createCollection(CollectionRequest collectionRequest) {


        String cifId = collectionRequest.getCifId();
        String nationalId = collectionRequest.getNationalId();
        String accountNumber = collectionRequest.getAccountNumber();

        // Call the endpoint to retrieve account details
        ApiResponse<AccountResponse[]> response = accountInterface.getAccountDetailsByCifIdOrAccountNumberOrNationalId(cifId, accountNumber, nationalId);


        // Check if the response is successful
        if (response != null && response.getStatusCode() == HttpStatus.OK.value()) {
            AccountResponse[] accountResponses = response.getData();

            // Check if accountResponses is not null and has at least one element
            if (accountResponses != null && accountResponses.length > 0) {
                // Assuming you want to use the first account response
                AccountResponse accountResponse = accountResponses[0];
                System.out.println(response);

                // Call the enterBeneficiaryDetails method
                ResponseEntity<?> beneficiaryResponseEntity = accountInterface.enterBeneficiaryDetails(collectionRequest.getBeneficiaryDto());


                // if (applicantResponseEntity != null && applicantResponseEntity.getStatusCode().is2xxSuccessful() &&
                if (beneficiaryResponseEntity != null && beneficiaryResponseEntity.getStatusCode().is2xxSuccessful()) {

                    // Proceed with creating the collection
                    String referenceNumber = CollectionRefUtil.generateReferenceNumber(collectionRequest.getCollectionType());
                    Good good = CollectionServiceUtil.mapToGood(collectionRequest.getGoodDto());
                    Shipment shipment = CollectionServiceUtil.mapToShipment(collectionRequest.getShipmentDto());
                    TenorDetails tenorDetails = CollectionServiceUtil.mapToTenorDetails(collectionRequest.getTenorDto());
                    ProtestDetails protestDetails = CollectionServiceUtil.mapToProtestDetails(collectionRequest.getProtestDto());
                    TracerDetails tracerDetails = CollectionServiceUtil.mapToTracerDetails(collectionRequest.getTracerDto());
                    Collection collection = Collection.builder()
                            .cifId(cifId)
                            .accountNumber(accountNumber)
                            .nationalId(nationalId)
                            .referenceNumber(referenceNumber)
                            .collectionType(collectionRequest.getCollectionType())
                            .billAmount(collectionRequest.getBillAmount())
                            .tenorType(collectionRequest.getTenorType())
                            .currencyCode(collectionRequest.getCurrencyCode())
                            .protestDate(collectionRequest.getProtestDate())
                            .good(good)
                            .shipment(shipment)
                            .tenorDetails(tenorDetails)
                            .protestDetails(protestDetails)
                            .tracerDetails(tracerDetails)
                            .acceptanceDate(collectionRequest.getAcceptanceDate())
                            .build();

                    collectionRepository.save(collection);
                    return new ApiResponse<>("Collection created successfully", null, HttpStatus.CREATED.value());
                } else {
                    return new ApiResponse<>("No account found for CIF ID", null, HttpStatus.NOT_FOUND.value());
                }
            } else {
                // Handle error response
                return new ApiResponse<>("Failed to retrieve account details", null, HttpStatus.NOT_FOUND.value());
            }
        } else {
            // Handle error response
            return new ApiResponse<>("Failed to retrieve account details", null, HttpStatus.NOT_FOUND.value());
        }
    }



    @Override
    public ApiResponse<String> createCopy(Long collectionId) {
        Optional<Collection> originalCollectionOptional = collectionRepository.findById(collectionId);
        if (originalCollectionOptional.isPresent()) {
            Collection originalCollection = originalCollectionOptional.get();
            // Generate a new reference number for the copy
            String newReferenceNumber = CollectionRefUtil.generateReferenceNumber(originalCollection.getCollectionType());
            Collection copyCollection = Collection.builder()
                    .function(originalCollection.getFunction())
                    .tenorType(originalCollection.getTenorType())
                    .currencyCode(originalCollection.getCurrencyCode())
                    .billAmount(originalCollection.getBillAmount())
                    .protestDate(originalCollection.getProtestDate())
                    .acceptanceDate(originalCollection.getAcceptanceDate())
                    .collectionType(originalCollection.getCollectionType())
                    .good(originalCollection.getGood())
                    .shipment(originalCollection.getShipment())
                    .build();
            collectionRepository.save(copyCollection);
            return new ApiResponse<>("Copy created successfully", null, HttpStatus.CREATED.value());
        } else {
            throw new IllegalArgumentException("Collection with ID " + collectionId + " not found.");
        }
    }


    @Override
    public ApiResponse<Collection>  modifyCollection(Long collectionId, CollectionRequest collectionRequest) {
        // Retrieve the original collection entity from the database
        Optional<Collection> originalCollectionOptional = collectionRepository.findById(collectionId);
        if (originalCollectionOptional.isPresent()) {
            Collection originalCollection = originalCollectionOptional.get();

            // Update the fields of the original collection entity
            originalCollection.setFunction(collectionRequest.getFunction());
            originalCollection.setTenorType(collectionRequest.getTenorType());
            originalCollection.setCurrencyCode(collectionRequest.getCurrencyCode());
            originalCollection.setBillAmount(collectionRequest.getBillAmount());
            originalCollection.setProtestDate(collectionRequest.getProtestDate());
            originalCollection.setAcceptanceDate(collectionRequest.getAcceptanceDate());
            originalCollection.setCollectionType(collectionRequest.getCollectionType());

            // Update other fields as needed

            // Save the updated collection entity to the database

            return new ApiResponse<>("Collection modified successfully", collectionRepository.save(originalCollection), 200);
        } else {
            throw new IllegalArgumentException("Collection with ID " + collectionId + " not found.");
        }

    }

    @Override
    public  ApiResponse<String> deleteCollection(Long collectionId) {
        // Check if the collection exists
        if (collectionRepository.existsById(collectionId)) {
            // Delete the collection with the given ID
            collectionRepository.deleteById(collectionId);
            return new ApiResponse<>("Collection deleted successfully", null, 200);
        } else {
            throw new IllegalArgumentException("Collection with ID " + collectionId + " not found.");
        }
    }
}