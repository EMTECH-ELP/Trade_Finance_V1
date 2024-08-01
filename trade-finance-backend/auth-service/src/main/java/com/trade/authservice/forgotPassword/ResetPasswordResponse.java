//package com.trade.authservice.forgotPassword;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.http.HttpStatus;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ResetPasswordResponse {
//    private String message;
//    private int statusCode;
//    private Object data; // You can include additional data if needed
//
//    public static ResetPasswordResponse success(String email) {
//        String message = "Password reset successful for email: " + email;
//        return new ResetPasswordResponse(message, HttpStatus.OK.value(), null);
//    }
//
//    public static ResetPasswordResponse userNotFound(String email) {
//        String message = "Failed to reset password. User with email " + email + " not found";
//        return new ResetPasswordResponse(message, HttpStatus.NOT_FOUND.value(), null);
//    }
//
//    public static ResetPasswordResponse invalidEmail(String email) {
//        String message = "Failed to reset password. Invalid email format: " + email;
//        return new ResetPasswordResponse(message, HttpStatus.BAD_REQUEST.value(), null);
//    }
//
//
//}
