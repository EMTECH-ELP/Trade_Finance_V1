package com.trade.authservice.Register;

import com.trade.authservice.OTP.*;
import com.trade.authservice.Token.Token;
import com.trade.authservice.Token.TokenRepository;
import com.trade.authservice.Token.TokenType;
import com.trade.authservice.User.Role;
import com.trade.authservice.User.User;
import com.trade.authservice.User.UserRepository;
import com.trade.authservice.mailService.MailService;
import com.trade.authservice.utils.EntityResponse;
import com.trade.authservice.utils.PasswordGeneratorUtil;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import static com.trade.authservice.User.Role.SUPER_ADMIN;
import static com.trade.authservice.utils.Status.ACTIVE;
import static com.trade.authservice.utils.Status.FLAGGED;

@Service
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final OTPService otpService;
    private final OTPRepository otpRepository;
    private final MailService mailService;

    //    @Autowired
//    MailService mailService;
    @Autowired
    public AuthenticationService(UserRepository userRepository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService, OTPService otpService, OTPRepository otpRepository, MailService mailService, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.otpService = otpService;
        this.tokenRepository = tokenRepository;
        this.otpRepository = otpRepository;
        this.mailService = mailService;

    }

    public EntityResponse<RegisterResponse> registerAdmin(RegisterRequest request) {
        EntityResponse<RegisterResponse> res = new EntityResponse<>();
        try {
            // Regular expression pattern for validating email format
            String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

            if (userRepository.existsByEmail(request.getEmail())) {
                res.setMessage("The user already exists! Kindly login");
                res.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            } else if (!request.getEmail().matches(emailPattern)) {
                res.setMessage("Invalid email format. Please provide a valid email address.");
                res.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            } else if (!isPasswordComplex(request.getPassword())) {
                res.setMessage("Password does not meet complexity requirements.");
                res.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            } else {
                // Log successful registration attempt
                log.info("User registration attempt with email: {}", request.getEmail());
                String generatedPassword = PasswordGeneratorUtil.generatePassayPassword();
                request.setPassword(generatedPassword);

                // Your existing code for user registration
                var user = User.builder()
                        .fullName(request.getFullName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(generatedPassword))
                        .role(Role.ADMIN)
                        .status(ACTIVE)
                        .firstLogin('Y')
                        .approvedFlag('Y')
                        .deletedFlag('N')
                        .build();

                var savedUser = userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);

                // Assuming you have a method like saveUserToken in your service
                saveUserToken(savedUser, jwtToken);

                var entity = RegisterResponse.builder()
                        .id(savedUser.getId())
                        .email(savedUser.getEmail())
                        .role(savedUser.getRole())
                        .accessToken(jwtToken)
                        .employeeID(savedUser.getEmployeeID())
                        .refreshToken(refreshToken)
                        .branchCode(savedUser.getBranchCode())
                        .branchName(savedUser.getBranchName())
                        .build();

                String mailMessage = String.format("""
                        <p>Dear <strong>%s</strong>,</p>
                        <p>Your account has been successfully created. Kindly login using:</p>
                        <p>Username: %s</p>
                        <p>Password: %s</p>""", user.getFullName(), user.getEmail(), generatedPassword);
                String subject = "Account Creation";

                mailService.sendEmail(user.getEmail(), null, mailMessage, subject, false, null, null);

                res.setEntity(entity);
                res.setMessage("User " + user.getUsername() + " registered successfully!");
                res.setStatusCode(HttpStatus.CREATED.value());
            }
        } catch (Exception e) {
            // Log registration failure
            log.error("An error occurred during user registration: {}", e.getMessage());

            res.setMessage("An error occurred during user registration.");
            res.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            // Set the entity to a default value or handle it based on your requirements
            res.setEntity(RegisterResponse.builder().build());
        }

        return res;
    }

    public EntityResponse<AuthenticationResponse> authenticateUser(AuthenticationRequest request) {
        EntityResponse<AuthenticationResponse> authResponse = new EntityResponse<>();

        try {
            Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
            if (userOpt.isPresent()) {
                User user = (User) ((Optional<?>) userOpt).get();
                if (user.getStatus().equals(FLAGGED)) {
                    log.warn("Authentication attempt for an account pending verification{}", user.getEmail());
                    authResponse.setMessage("Account pending verification. Please contact Admin");
                    authResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                    return authResponse;
                }

                // Check if the account is locked
                if (user.getAccountLocked()) {
                    log.warn("Authentication attempt for locked account: {}", user.getEmail());
                    authResponse.setMessage("Account is locked. Please contact Administrator.");
                    authResponse.setStatusCode(HttpStatus.LOCKED.value());
                    return authResponse;
                }
                String password = request.getPassword();
                String encodedPassword = user.getPassword();
                String jwtToken = jwtService.generateToken(user);
                if (!passwordEncoder.matches(password, encodedPassword)){
                    user.incrementFailedAttempts();
                    userRepository.save(user);
                }

//                String password = request.getPassword();
//                if (password == null) {
//                    // Handle the case where the password is null
//                    log.warn("Password provided by user is null.");
//                    authResponse.setMessage("Password cannot be null.");
//                    authResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
//                    return authResponse;
//                }

//                String encodedPassword = user.getPassword();

                if (!passwordEncoder.matches(password, encodedPassword)) {
                    // Increment consecutive failed attempts
                    user.incrementFailedAttempts();
                    userRepository.save(user);

                    // Check if the account needs to be locked
                    if (user.getFailedLoginAttempts() >= 3) {
                        // Lock the account
                        user.setAccountLocked(true);
                        userRepository.save(user);
                        log.warn("Account locked due to multiple failed login attempts for user: {}", user.getEmail());
                        authResponse.setMessage("Account locked due to multiple failed attempts.");
                        authResponse.setStatusCode(HttpStatus.LOCKED.value());
                        return authResponse;
                    }

                    log.info("Incorrect password attempt for user: {}. Failed attempts: {}", user.getEmail(), user.getFailedLoginAttempts());
                    authResponse.setMessage("Incorrect email/password");
                    authResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                } else {
                    if (user.getFirstLogin().equals('N')){
                        // Generate and send OTP
                        String otp = otpService.generateOtp(user.getEmail());
                        sendOtpToEmail(user.getFullName(), user.getEmail(), otp);

                        AuthenticationResponse res = AuthenticationResponse.builder()
                                .id(user.getId())
                                .email(user.getEmail())
                                .otpRequired(true)
                                .role(String.valueOf(user.getRole()))
                                .firstLogin('N')
                                .build();

                        authResponse.setEntity(res);
                        authResponse.setStatusCode(HttpStatus.MULTI_STATUS.value());
                        authResponse.setMessage("Please enter OTP sent to your email.");
                        return authResponse;
                    }
                    AuthenticationResponse entity = AuthenticationResponse.builder()
                            .id(user.getId())
                            .email(user.getEmail() )
                            .otpRequired(false)
                            .role(String.valueOf(user.getRole()))
                            .firstLogin('Y')

                            .build();

                    authResponse.setEntity(entity);
                    authResponse.setStatusCode(HttpStatus.MULTI_STATUS.value());
                    authResponse.setMessage("First login detected. Please reset your password.");
                    return authResponse;
                }

            } else {
                log.info("User not found for email: {}", request.getEmail());
                authResponse.setMessage("User not found");
                authResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception e) {
            log.error("Error while retrieving/authenticating the user", e);
            authResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            authResponse.setMessage("Internal Server Error!");
        }

        return authResponse;
    }

    private void sendOtpToEmail(String fullName,String email,String otp) throws MessagingException, MessagingException {
        User user = new User();
        String mailMessage = String.format("""
                <p>Dear <strong>%s</strong>,</p>
                <p>Kindly use the below OTP to finish your login:</p>
                <p>OTP: %s</p>
                """, fullName, otp);
        String subject = "OTP Validation";

        mailService.sendEmail(email, null, mailMessage, subject, false, null, null);

    }

    public EntityResponse<OTPResponse> validateOTP(OTPCode otpCode) {
        EntityResponse<OTPResponse> response = new EntityResponse<>();

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime validTime = currentTime.minusMinutes(5);

        OTP otp = otpRepository.validOTP(otpCode.getEmail(), validTime);
        if (otp == null || !Objects.equals(otp.getOtp(), otpCode.getOtp())) {
            response.setMessage("OTP is not valid!");
            response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        } else {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("OTP validated, Successfully signed in");

            otpRepository.delete(otp);

            User user = userRepository.findByEmail(otpCode.getEmail()).orElse(null);
            if (user != null) {
                // Reset failed attempts upon successful login
                user.setFailedLoginAttempts(0);
                user.setStatus(ACTIVE);
                user.setFirstLogin(user.getFirstLogin());
                // Check if it's the user's first login
                if (user.getFirstLogin() == 'Y') {
                    if (user.getRole() == SUPER_ADMIN) {
                        user.setFirstLogin('N');

                    }else {

                        // Prompt user to reset password on first login
                        response.setMessage("First login detected. Please reset your password.");
                        response.setStatusCode(HttpStatus.FORBIDDEN.value());
                    }
                }
                userRepository.save(user);

                String jwtToken = jwtService.generateToken(user);
                // Revoke previous tokens (optional)
                revokeAllUserTokens(user);
                // Save new tokens for the user (optional)
                saveUserToken(user, jwtToken);


                OTPResponse otpResponse = new OTPResponse();
                otpResponse.setEmail(user.getEmail());
                otpResponse.setAccessToken(jwtToken);
                otpResponse.setId(user.getId());
                otpResponse.setRole(user.getRole());


                response.setEntity(otpResponse);
            } else {
                response.setMessage("User not found");
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        }

        return response;
    }

    public EntityResponse<?> logout(
            SignOutRequest signOutRequest
    ){
        try {
            String accessToken = signOutRequest.getAccessToken();
            String userEmail = jwtService.extractUsername(accessToken);

            if (userEmail != null) {
                var user = this.userRepository.findByEmail(userEmail).orElseThrow();

                // Revoke all tokens for the user
                revokeAllUserTokens(user);
                return new EntityResponse<>("Sign out was successful.", HttpStatus.OK.value(), null, null);
            }

            return new EntityResponse<>("Invalid access token.", HttpStatus.BAD_REQUEST.value(), null, null);
        } catch (Exception e) {
            return null;
        }

    }


    private void saveUserToken(User user, String jwtToken) {
        long currentTimeMillis = System.currentTimeMillis();
        Date expirationDate = new Date(currentTimeMillis + (10 * 60 * 1000));
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .expirationDate(expirationDate)
                .build();
        tokenRepository.save(token);
    }
    private void revokeAllUserTokens (User user){
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


    private boolean isPasswordComplex(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$");
    }

//    @PostMapping("/forgotPassword")
//    public EntityResponse<?> forgotPassword(ForgotPassword forgotPassword) throws MessagingException, IOException {
//        if (userRepository.existsByEmail(forgotPassword.getEmail())) {
//            EntityResponse response = new EntityResponse<>();
//            response.setMessage("No account associated with the email provided" + forgotPassword.getEmail());
//            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//            response.setEntity("");
//            return new EntityResponse<>(response, HttpStatus.OK);
//        } else {
//            PasswordGeneratorUtil passwordGenerator = new PasswordGeneratorUtil();
//            String generatedPassword = PasswordGeneratorUtil.generatePassayPassword();
//            Optional<User> user = userRepository.findByEmail(forgotPassword.getEmail());
//            if (user.isPresent()) {
//                User existingUser = user.get();
//                existingUser.setPassword(encoder.encode(generatedPassword));
//                existingUser.setPassword(String.valueOf(true));
////                existingUser.setModifiedBy(user.get().getUsername());
////                //newuser.setModifiedBy(newuser.getUsername());
////                existingUser.setModifiedOn(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
//                userRepository.save(existingUser);
//                String subject = "PASSWORD RESET:";
//                //String userIdentity = "User";
//                String mailMessage = //"<p>Dear <strong>" + userIdentity  +"</strong>,</p>\n" +
//                        "  <p>Your password has been successfully updated. Find the following credentials that you will use to access the application:</p>\n" +
//                                "  <ul>\n" +
//                                "    <li>Username: <strong>" + user.get().getUsername() + "</strong></li>\n" +
//                                "    <li>Password: <strong>" + generatedPassword + "</strong></li>\n" +
//                                "  </ul>\n" +
//                                "  <p>Please login to change your password.</p>";
//                mailService.sendEmail(((User) existingUser).getEmail(), null, mailMessage, subject, false, null, null);
//                EntityResponse response = new EntityResponse();
//                log.info("-------------------------" + generatedPassword);
//                response.setMessage("Password Reset Successfully! Password has been sent to the requested email");
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setEntity("");
//                return new ResponseEntity<>(response, HttpStatus.OK).getBody();
//            } else {
//                EntityResponse response = new EntityResponse();
//                response.setMessage("User with email address not found!");
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity("");
//                return new ResponseEntity<>(response, HttpStatus.OK).getBody();
//
//            }
//        }
//
//    }
}
