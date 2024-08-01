//package com.TradeFinance.LetterOfCredit.swift;
//
//import com.TradeFinance.bankguarantee.dto.ErrorResponseDto;
//import com.TradeFinance.dto.LetterOfCreditRequest;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value ="/api/swift")
//public class MT700Controller {
//
//    private final MT700Service mt700Service;
//
//    @Autowired
//    public MT700Controller(MT700Service mt700Service) {
//        this.mt700Service = mt700Service;
//    }
//
//    @Operation(
//            summary = "Create MT700 REST API",
//            description = "REST API to create new MT700"
//    )
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(
//                    responseCode = "201",
//                    description = "HTTP Status CREATED"
//            ),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(
//                    responseCode = "500",
//                    description = "HTTP Status Internal Server Error",
//                    content = @Content(
//                            schema = @Schema(implementation = ErrorResponseDto.class)
//                    )
//            )
//    }
//    )
//    @PostMapping("/generateMT700")
//    public ResponseEntity<String> generateMT700(@RequestBody LetterOfCreditRequest request) throws JsonProcessingException {
//        String mt700Message = mt700Service.generateMT700(request);
//        return ResponseEntity.ok(mt700Message);
//    }
//}
//
