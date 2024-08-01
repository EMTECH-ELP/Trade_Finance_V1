//package com.trade.authservice.forgotPassword;
//
//import com.trade.authservice.User.User;
//import com.trade.authservice.User.UserRepository;
//import com.trade.authservice.mailService.MailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PasswordServiceImpl implements PasswordService {
//
//    @Autowired
//    private UserRepository userRepository; // Assuming you have a UserRepository to interact with the database
//
//    @Autowired
//    private MailService mailService; // Assuming you have a MailService to send emails
//
//    @Autowired
//    private PasswordEncoder encoder; // Assuming you have a PasswordEncoder to encode passwords
//
//    @Override
//    public boolean resetPassword(String email) {
//        // Check if user exists with the provided email
//        Optional<User> user = userRepository.findByEmail(email);
//        return false; // User not found
//
//        // Generate a new password
//    }
//
//    private String generateNewPassword() {
//        // You can implement your own password generation logic here
//        // For simplicity, let's return a fixed password
//        return "newPassword123";
//    }
//
//    private void sendPasswordEmail(String email, String newPassword) {
//        // Assuming you have a method in MailService to send the email
//        String subject = "Password Reset";
//        String message = "Your password has been reset. Your new password is: " + newPassword;
//        mailService.sendEmail(email, subject, message);
//    }
//}
