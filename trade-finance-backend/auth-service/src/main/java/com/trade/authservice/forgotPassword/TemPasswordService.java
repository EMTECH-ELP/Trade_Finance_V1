package com.trade.authservice.forgotPassword;

import com.trade.authservice.User.User;
import com.trade.authservice.User.UserRepository;
import com.trade.authservice.demo.PasswordGenerator;
import com.trade.authservice.mailService.MailService;
import com.trade.authservice.utils.EntityResponse;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.SecureRandom;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class TemPasswordService {

    private final JavaMailSender javaMailSender;

    private final UserRepository userRepository;

    private static final SecureRandom random = new SecureRandom();
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;
    private User user;

    public TemPasswordService(PasswordEncoder passwordEncoder, JavaMailSender javaMailSender, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
        this.userRepository = userRepository;
    }

    public EntityResponse<?> sendTemPassword(String email) {
        EntityResponse<?> temP = new EntityResponse<>();
        Optional<User> existingUser = userRepository.findByEmail(email);
        log.info("Sending temporary password to email: {}", temP);

        try {
            if (existingUser.isPresent()) {
                String temPassword = PasswordGenerator.generateRandomPassword(6); // Assuming 6 is the desired length
                sendTemPasswordToEmail(existingUser.get(), temPassword);

                log.info("Temporary password sent successfully to email: {}", email);
                temP.setMessage("Temporary password sent successfully to email: " + email);
                //temP.setEntity(temPasswordRepository.save(email));
                temP.setStatusCode(HttpStatus.OK.value());
            }
            else {
                temP.setMessage("Email does not exist kindly input the correct email");
                temP.setStatusCode(HttpStatus.NOT_FOUND.value());
                temP.setEntity(null);
            }
        } catch (Exception exception) {
            log.error("Error sending temporary password to email: {}", email, exception);
            temP.setMessage("Temporary password not sent");
            temP.setEntity(null);
            temP.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        }
        return temP;

    }

    private void sendTemPasswordToEmail(User user, String password) throws MessagingException {
        String fullName = user.getFullName();
        String email = user.getEmail();

        String mailMessage = String.format("<p>Dear <strong>%s</strong>,</p>\n" +
                "<p>Kindly use the below temporary password to reset your password:</p>\n" +
                "<p>Temporary Password: %s</p>\n", fullName, password);
        String subject = "Password Reset";

        mailService.sendEmail(email, null, mailMessage, subject, false, null, null);

        // Save the temporary password along with the email and timestamp, etc.
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

//    @Scheduled(fixedRate = 600000) // 10 minutes in milliseconds
//    public void deleteExpiredPasswords() {
//        Date tenMinutesAgo = new Date(System.currentTimeMillis() - (10 * 60 * 1000));
//        temPasswordRepository.deleteByRequestedTimeBefore(tenMinutesAgo);
//    }

    public EntityResponse<MessageResponse> resetPassword(@RequestBody ResetPasswordRequest resetRequest) {
        EntityResponse<MessageResponse> response = new EntityResponse<>();

        try {
            Optional<User> optUser = userRepository.findByEmail(resetRequest.getEmail());
            if (optUser.isPresent()) {
                User user = optUser.get();

                // Check if the current password matches the password stored in the database
                if (!passwordEncoder.matches(resetRequest.getCurrentPassword(), user.getPassword())) {
                    response.setMessage("The current password is incorrect!");
                    response.setStatusCode(HttpStatus.NOT_FOUND.value());
                    return response;
                }

                // Validate new and confirm passwords
                if (!resetRequest.getNewPassword().equals(resetRequest.getConfirmPassword())) {
                    response.setMessage("New password and confirm password do not match");
                    response.setStatusCode(HttpStatus.BAD_REQUEST.value());
                    return response;
                }
                if ((!isPasswordComplex(resetRequest.getNewPassword()))) {
                    response.setMessage("Password does not meet complexity requirements.");
                    response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                    return response;
                }
                // Update password
                user.setPassword(passwordEncoder.encode(resetRequest.getNewPassword())); // Ensure to encode the new password
                user.setFirstLogin('N');
                userRepository.save(user);
                var entity = MessageResponse.builder()
                        .email(resetRequest.getEmail())
                        .id(user.getId())
                        .build();

                response.setMessage("Password reset successful");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity(entity);
            } else {
                response.setMessage("User not found");
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception exception) {
            log.error("Error resetting password", exception);
            response.setMessage("An error occurred while resetting the password");
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return response;
    }
    private boolean isPasswordComplex(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$");
    }

}
