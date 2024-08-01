//package com.trade.authservice.forgotPassword;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ResetPasswordController {
//
//    @Autowired
//    private PasswordService passwordService; // Assuming you have a service to handle password-related operations
//
//    @PostMapping("/resetPassword")
//    public ResponseEntity<ResetPasswordResponse> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
//        String email = resetPasswordRequest.getEmail();
//
//        // Assuming you have a service method to handle the password reset operation
//        boolean resetSuccess = passwordService.resetPassword(email);
//
//        if (resetSuccess) {
//            // If password reset is successful
//            return ResponseEntity.ok(ResetPasswordResponse.success(email));
//        } else {
//            // If password reset fails (e.g., user not found)
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResetPasswordResponse.userNotFound(email));
//        }
//    }
//}
