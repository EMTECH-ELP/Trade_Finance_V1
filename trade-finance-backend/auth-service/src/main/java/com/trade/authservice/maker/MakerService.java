package com.trade.authservice.maker;

import com.trade.authservice.tradeFinance.*;
import com.trade.authservice.utils.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakerService {

    private final LetterOfCreditService lcService;
    private final BillService billService;
    private final BankGuaranteeService bgService;
    private final DocumentaryCollectionService dcService;
    private final InvoiceDiscountingService idService;

    @Autowired

    public MakerService(LetterOfCreditService lcService, BillService billService,
                        BankGuaranteeService bgService, DocumentaryCollectionService dcService,
                        InvoiceDiscountingService idService) {
        this.lcService = lcService;
        this.billService = billService;
        this.bgService = bgService;
        this.dcService = dcService;
        this.idService = idService;
    }

    public EntityResponse<?> createLC(LCCreationRequest request) {
        return lcService.createLC(request);
    }

    public EntityResponse<?> createBill(BillCreationRequest request) {
        return billService.createBill(request);
    }

    public EntityResponse<?> createBankGuarantee(BGCreationRequest request) {
        return bgService.createBankGuarantee(request);
    }

    public EntityResponse<?> createDocumentaryCollection(DCCreationRequest request) {
        return dcService.createDocumentaryCollection(request);
    }

    public EntityResponse<?> createInvoiceDiscounting(IDCreationRequest request) {
        return idService.createInvoiceDiscounting(request);
    }
}


//import com.trade.authservice.Register.JwtService;
//import com.trade.authservice.Register.RegisterRequest;
//import com.trade.authservice.Register.RegisterResponse;
//import com.trade.authservice.Requests.ChangeRoleRequest;
//import com.trade.authservice.Token.Token;
//import com.trade.authservice.Token.TokenRepository;
//import com.trade.authservice.Token.TokenType;
//import com.trade.authservice.User.Role;
//import com.trade.authservice.User.User;
//import com.trade.authservice.User.UserDto;
//import com.trade.authservice.User.UserRepository;
//import com.trade.authservice.forgotPassword.TemPassword;
//import com.trade.authservice.mailService.MailService;
//import com.trade.authservice.utils.EntityResponse;
//import com.trade.authservice.utils.PasswordGenerator;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Slf4j
//
//
//public class MakerService {
//    private final TemPassword temPassword;
//    private final UserRepository userRepository;
//    private final MailService mailService;
//    private final TokenRepository tokenRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//
//    @Autowired
//    public MakerService(TemPassword temPassword, UserRepository userRepository, MailService mailService, TokenRepository tokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
//        this.temPassword = temPassword;
//        this.userRepository = userRepository;
//        this.mailService = mailService;
//        this.tokenRepository = tokenRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//    }
//
//    public EntityResponse<RegisterResponse> addNewUser(RegisterRequest request) {
//        EntityResponse<RegisterResponse> res = new EntityResponse<>();
//        try {
//            if (userRepository.existsByEmail(request.getEmail())) {
//                res.setMessage("The user already exists! Kindly login");
//                res.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//            } else {
//                // Generate a random password for non-admin, non-checker, non-maker roles
//                Role role = request.getRole();
//                String generatedPassword = null;
//                if (role != Role.ADMIN && role != Role.CHECKER && role != Role.MAKER) {
//                    generatedPassword = PasswordGenerator.generateRandomPassword(10); // Adjust length as needed
//                }
//
//                User user = User.builder()
//                        .fullName(request.getFullName())
//                        .email(request.getEmail())
//                        // Ensure the password is encoded before saving
//                        .password(passwordEncoder.encode(generatedPassword != null ? generatedPassword : ""))
//                        .role(request.getRole())
//                        .status(request.getStatus())
//                        .approvedFlag('N')
//                        .firstLogin('Y')
//                        .deletedFlag('N')
//                        .accountLocked(false)
//                        .build();
//
//                User savedUser = userRepository.save(user);
//                String jwtToken = jwtService.generateToken(savedUser);
//                String refreshToken = jwtService.generateRefreshToken(savedUser);
//
//                // Assuming you have a method like saveUserToken in your service
//                saveUserToken(savedUser, jwtToken);
//
//                RegisterResponse entity = RegisterResponse.builder()
//                        .id(savedUser.getId())
//                        .email(savedUser.getEmail())
//                        .role(savedUser.getRole())
//                        .accessToken(jwtToken)
//                        // Uncomment and use if refresh token is needed
//                        .refreshToken(refreshToken)
//                        .build();
//
//                String mailMessage = String.format("" +
//                        "<p>Dear <strong>%s</strong>,</p>\n" +
//                        "<p>Your account has been successfully created. Kindly login using:</p>\n" +
//                        "<p>Username: %s</p>\n" +
//                        "<p>Password: %s</p>", user.getFullName(), user.getEmail(), generatedPassword != null ? generatedPassword : "");
//                String subject = "Account Creation";
//
//                mailService.sendEmail(user.getEmail(), null, mailMessage, subject, false, null, null);
//                res.setEntity(entity);
//                res.setMessage("User " + user.getEmail() + " registered successfully!");
//                res.setStatusCode(HttpStatus.CREATED.value());
//            }
//        } catch (Exception e) {
//            res.setMessage("An error occurred during user registration.");
//            res.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            // Set the entity to a default or null value as needed
//            res.setEntity(null);
//        }
//
//        return res;
//    }
//
//    public EntityResponse findUserById(Long id){
//        EntityResponse responseEntity = new EntityResponse();
//        Optional<User> existingUser = userRepository.findById(id);
//        try {
//            if (existingUser.isPresent()){
//                responseEntity.setEntity(existingUser);
//                responseEntity.setMessage("User retrieved successfully!");
//                responseEntity.setStatusCode(HttpStatus.FOUND.value());
//            }else {
//                responseEntity.setMessage("User Not Found!");
//                responseEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
//                responseEntity.setEntity(null);
//            }
//        } catch (Exception e) {
//            log.error("Error {}", e.getMessage());
//            responseEntity.setEntity(null);
//            responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            responseEntity.setMessage("Error while retrieving Vendor!");
//        }
//        return responseEntity;
//
//    }
//
//    public EntityResponse findUserByEmail(String email){
//        EntityResponse response = new EntityResponse();
//        Optional<User> existingUser = userRepository.findByEmail(email);
//        try{
//            if (existingUser.isPresent()){
//                User savedUser = existingUser.get();
//                response.setMessage("User retrieved successfully!");
//                response.setStatusCode(HttpStatus.FOUND.value());
//                response.setEntity(savedUser);
//            }else {
//                response.setMessage("User Not Found!");
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity(null);
//            }
//        } catch (Exception e) {
//            log.error("Error {}", e.getMessage());
//            response.setEntity(null);
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setMessage("Error while retrieving Vendor!");
//        }
//        return response;
//
//    }
//
//    public EntityResponse<List<UserDto>> getAllUsers() throws Exception {
//        EntityResponse<List<UserDto>> responseEntity = new EntityResponse<>();
//        try {
//            List<User> existingUsers = userRepository.findAll();
//            List<UserDto> userDtos = new ArrayList<>();
//
//            for (User user : existingUsers) {
//                UserDto userDto = new UserDto();
//                userDto.setId(user.getId());
//                userDto.setEmail(user.getEmail());
//                userDto.setRole(user.getRole());
//                userDtos.add(userDto);
//            }
//            responseEntity.setEntity(userDtos);
//            responseEntity.setMessage("Users retrieved successfully");
//            responseEntity.setStatusCode(HttpStatus.FOUND.value());
//
//        }
//        catch (Exception e) {
//            log.error("Error while retrieving Users");
//            responseEntity.setEntity(null);
//            responseEntity.setMessage("Internal Server Error");
//            responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        }
//
//        return responseEntity;
//    }
//
//    public EntityResponse<?> changeUserRoleById(ChangeRoleRequest request) {
//        EntityResponse response = new EntityResponse();
//        Optional<User> existingUser = userRepository.findById(request.getId());
//
//        try {
//            if (existingUser.isPresent()) {
//                User savedUser = existingUser.get();
//                savedUser.setRole(request.getNewRole());
//                userRepository.save(savedUser);
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setEntity(savedUser);
//                response.setMessage("Role changed successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity(null);
//                response.setMessage("User not found");
//            }
//
//        } catch (Exception e) {
//            log.error("Error while changing user role");
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setEntity(null);
//            response.setMessage("Internal server error");
//        }
//        return response;
//    }
//
//    public EntityResponse<?> changeUserRoleByEmail(ChangeRoleRequest request) {
//        EntityResponse response = new EntityResponse();
//        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
//
//        try {
//            if (existingUser.isPresent()) {
//                User savedUser = existingUser.get();
//                savedUser.setRole(request.getNewRole());
//                userRepository.save(savedUser);
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setEntity(savedUser);
//                response.setMessage("Role changed successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity(null);
//                response.setMessage("User not found");
//            }
//
//        } catch (Exception e) {
//            log.error("Error while changing user role");
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setEntity(null);
//            response.setMessage("Internal server error");
//        }
//        return response;
//    }
//
//
//    @Transactional
//    public EntityResponse deleteUserById(Long id) {
//        EntityResponse responseEntity = new EntityResponse();
//        Optional<User> existingUser = userRepository.findById(id);
//
//        try {
//            if (existingUser.isPresent()) {
//                User deletedUser = existingUser.get();
//
//                log.info("Deleting associated tokens for user with id: {}", id);
//
//                // Manually delete associated tokens
//                tokenRepository.deleteByUserId(id);
//
//                log.info("Tokens deleted successfully for user with id: {}", id);
//                log.info("Deleting user with id: {}", id);
//
//                deletedUser.setDeletedFlag('Y');
//
//                // Now delete the user
//                userRepository.delete(deletedUser);
//
//                log.info("User deleted successfully with id: {}", id);
//
//                responseEntity.setStatusCode(HttpStatus.OK.value());
//                responseEntity.setMessage("User deleted successfully");
//                responseEntity.setEntity(deletedUser);
//            } else {
//                responseEntity.setEntity(null);
//                responseEntity.setMessage("User Not found");
//                responseEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
//            }
//        } catch (Exception e) {
//            log.error("Error while deleting the User with id: {}", id, e);
//            responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            responseEntity.setMessage("INTERNAL SERVER ERROR");
//            responseEntity.setEntity(null);
//        }
//
//        return responseEntity;
//    }
//
//    private void saveUserToken(User user, String jwtToken) {
//        long currentTimeMillis = System.currentTimeMillis();
//        Date expirationDate = new Date(currentTimeMillis + (10 * 60 * 1000));
//        var token = Token.builder()
//                .user(user)
//                .token(jwtToken)
//                .tokenType(TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .expirationDate(expirationDate)
//                .build();
//        tokenRepository.save(token);
//    }
//
//    public EntityResponse<?> unlockAccountById(Long id) {
//        EntityResponse<?> response = new EntityResponse<>();
//
//        try {
//            Optional<User> userOpt = userRepository.findById(id);
//            if (userOpt.isPresent()) {
//                User user = userOpt.get();
//
//                // Unlock the account
//                user.resetFailedAttempts();
//                user.unlockAccount();
//
//                // Revoke existing tokens for security (optional but recommended)
//                revokeAllUserTokens(user);
//
//                userRepository.save(user);
//
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setMessage("Account unlocked successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setMessage("User not found");
//            }
//        } catch (Exception e) {
//            log.error("Error while unlocking the user account", e);
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setMessage("Internal server error");
//        }
//
//        return response;
//    }
//
//    private void revokeAllUserTokens (User user){
//        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//        if (validUserTokens.isEmpty())
//            return;
//        validUserTokens.forEach(token -> {
//            token.setExpired(true);
//            token.setRevoked(true);
//        });
//        tokenRepository.saveAll(validUserTokens);
//    }
//
//    @Transactional
//    public EntityResponse<?> unlockAccountByEmail(String email) {
//        EntityResponse<?> response = new EntityResponse<>();
//
//        try {
//            Optional<User> userOpt = userRepository.findByEmail(email);
//            if (userOpt.isPresent()) {
//                User user = userOpt.get();
//
//                // Unlock the account
//                user.resetFailedAttempts();
//                user.unlockAccount();
//
//                // Revoke existing tokens for security (optional but recommended)
//                revokeAllUserTokens(user);
//
//                userRepository.save(user);
//
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setMessage("Account unlocked successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setMessage("User not found with email: " + email);
//            }
//        } catch (Exception e) {
//            log.error("Error while unlocking the user account", e);
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setMessage("Internal server error");
//        }
//
//        return response;
//    }
//
//    public List<User> findAllLockedAccounts() {
//        return userRepository.findAllByAccountLockedTrue();
//    }
//}









//package com.trade.authservice.maker;
//
//import com.trade.authservice.Register.JwtService;
//import com.trade.authservice.Register.RegisterRequest;
//import com.trade.authservice.Register.RegisterResponse;
//import com.trade.authservice.Requests.ChangeRoleRequest;
//import com.trade.authservice.Token.Token;
//import com.trade.authservice.Token.TokenRepository;
//import com.trade.authservice.Token.TokenType;
//import com.trade.authservice.User.Role;
//import com.trade.authservice.User.User;
//import com.trade.authservice.User.UserDto;
//import com.trade.authservice.User.UserRepository;
//import com.trade.authservice.forgotPassword.TemPassword;
//import com.trade.authservice.mailService.MailService;
//import com.trade.authservice.utils.EntityResponse;
//import com.trade.authservice.utils.PasswordGenerator;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static com.trade.authservice.utils.Status.ACTIVE;
//
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class MakerService {
//    @Autowired
//    TemPassword temPassword;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    MailService mailService;
//    @Autowired
//    private TokenRepository tokenRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Autowired
//    private JwtService jwtService;
////    private final AuthenticationManager authenticationManager;
//    @Autowired
//    public MakerService(TemPassword temPassword, UserRepository userRepository, MailService mailService, TokenRepository tokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
//        this.temPassword = temPassword;
//        this.userRepository = userRepository;
//        this.mailService = mailService;
//        this.tokenRepository = tokenRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//    }
//// private final AuthenticationManager authenticationManager;
//    public EntityResponse<RegisterResponse> addNewUser(RegisterRequest request) {
//        EntityResponse<RegisterResponse> res = new EntityResponse<>();
//        try {
//            if (userRepository.existsByEmail(request.getEmail())) {
//                res.setMessage("The user already exists! Kindly login");
//                res.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//            } else {
//                // Automatically generates a password if the complexity check is only for manually entered passwords,
//                // remove or adjust this condition based on your needs.
//                Role role = request.getRole();
//                if (role != Role.ADMIN && role != Role.CHECKER && role != Role.MAKER) {
//                    String generatedPassword = PasswordGenerator.generateRandomPassword(6);
//                    request.setPassword(generatedPassword);
//                    User user = User.builder()
//                            .fullName(request.getFullName())
//                            .email(request.getEmail())
//                            // Ensure the password is encoded before saving
//                            .password(passwordEncoder.encode(request.getPassword()))
//                            .role(request.getRole())
//                            .status(request.getStatus())
//                            .approvedFlag('N')
//                            .firstLogin('Y')
//                            .deletedFlag('N')
//                            .accountLocked(false)
//                            .build();
//
//                    User savedUser = userRepository.save(user);
//                    String jwtToken = jwtService.generateToken(savedUser);
//                    String refreshToken = jwtService.generateRefreshToken(savedUser);
//
//                    // Assuming you have a method like saveUserToken in your service
//                    saveUserToken(savedUser, jwtToken);
//
//                    RegisterResponse entity = RegisterResponse.builder()
//                            .id(savedUser.getId())
//                            .email(savedUser.getEmail())
//                            .role(savedUser.getRole())
//                            .accessToken(jwtToken)
//                            // Uncomment and use if refresh token is needed
//                            .refreshToken(refreshToken)
//                            .build();
//
//                    String mailMessage = String.format("" +
//                            "<p>Dear <strong>%s</strong>,</p>\n" +
//                            "<p>Your account has been successfully created. Kindly login using:</p>\n" +
//                            "<p>Username: %s</p>\n" +
//                            "<p>Password: %s</p>", user.getFullName(), user.getEmail(), generatedPassword);
//                    String subject = "Account Creation";
//
//                    mailService.sendEmail(user.getEmail(), null, mailMessage, subject, false, null, null);
//                    res.setEntity(entity);
//                    res.setMessage("User " + user.getEmail() + " registered successfully!");
//                    res.setStatusCode(HttpStatus.CREATED.value());
//                } else {
//                    User user = User.builder()
//                            .fullName(request.getFullName())
//                            .email(request.getEmail())
//                            // Ensure the password is encoded before saving
//                            .password(passwordEncoder.encode(request.getPassword()))
//                            .role(request.getRole())
//                            .status(ACTIVE)
//                            .approvedFlag('Y')
//                            .firstLogin('Y')
//                            .deletedFlag('N')
//                            .accountLocked(false)
//                            .build();
//
//                    User savedUser = userRepository.save(user);
//                    String jwtToken = jwtService.generateToken(savedUser);
//                    String refreshToken = jwtService.generateRefreshToken(savedUser);
//
//                    // Assuming you have a method like saveUserToken in your service
//                    saveUserToken(savedUser, jwtToken);
//
//                    RegisterResponse entity = RegisterResponse.builder()
//                            .id(savedUser.getId())
//                            .email(savedUser.getEmail())
//                            .role(savedUser.getRole())
//                            .accessToken(jwtToken)
//                            // Uncomment and use if refresh token is needed
//                            .refreshToken(refreshToken)
//                            .build();
//
//                    String mailMessage = String.format("" +
//                            "<p>Dear <strong>%s</strong>,</p>\n" +
//                            "<p>Your account has been successfully created. Kindly login using:</p>\n" +
//                            "<p>Username: %s</p>\n" +
//                            "<p>Password: %s</p>", user.getFullName(), user.getEmail(), request.getPassword());
//                    String subject = "Account Creation";
//
//                    mailService.sendEmail(user.getEmail(), null, mailMessage, subject, false, null, null);
//                    res.setEntity(entity);
//                    res.setMessage("User " + user.getEmail() + " registered successfully!");
//                    res.setStatusCode(HttpStatus.CREATED.value());
//
//                }
//            }
//        } catch (Exception e) {
//            res.setMessage("An error occurred during user registration.");
//            res.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            // Set the entity to a default or null value as needed
//            res.setEntity(null);
//        }
//
//        return res;
//    }
//    public EntityResponse findUserById(Long id){
//        EntityResponse responseEntity = new EntityResponse();
//        Optional<User> existingUser = userRepository.findById(id);
//        try {
//            if (existingUser.isPresent()){
//                responseEntity.setEntity(existingUser);
//                responseEntity.setMessage("User retrieved successfully!");
//                responseEntity.setStatusCode(HttpStatus.FOUND.value());
//            }else {
//                responseEntity.setMessage("User Not Found!");
//                responseEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
//                responseEntity.setEntity(null);
//            }
//        } catch (Exception e) {
//            log.error("Error {}");
//            responseEntity.setEntity(null);
//            responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            responseEntity.setMessage("Error while retrieving Vendor!");
//        }
//        return responseEntity;
//
//    }
//    public EntityResponse findUserByEmail(String email){
//        EntityResponse response = new EntityResponse();
//        Optional<User> existingUser = userRepository.findByEmail(email);
//        try{
//            if (existingUser.isPresent()){
//                User savedUser = existingUser.get();
//                response.setMessage("User retrieved successfully!");
//                response.setStatusCode(HttpStatus.FOUND.value());
//                response.setEntity(savedUser);
//            }else {
//                response.setMessage("User Not Found!");
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity(null);
//            }
//        } catch (Exception e) {
//            log.error("Error {}");
//            response.setEntity(null);
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setMessage("Error while retrieving Vendor!");
//        }
//        return response;
//
//    }
//    public EntityResponse<List<UserDto>> getAllUsers() throws Exception {
//        EntityResponse<List<UserDto>> responseEntity = new EntityResponse<>();
//        try {
//            List<User> existingUsers = userRepository.findAll();
//            List<UserDto> userDtos = new ArrayList<>();
//
//            for (User user : existingUsers) {
//                UserDto userDto = new UserDto();
//                userDto.setId(user.getId());
//                userDto.setEmail(user.getEmail());
//                userDto.setRole(user.getRole());
//                userDtos.add(userDto);
//            }
//            responseEntity.setEntity(userDtos);
//            responseEntity.setMessage("Users retrieved successfully");
//            responseEntity.setStatusCode(HttpStatus.FOUND.value());
//
//        }
//        catch (Exception e) {
//            log.error("Error while retrieving Users");
//            responseEntity.setEntity(null);
//            responseEntity.setMessage("Internal Server Error");
//            responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        }
//
//        return responseEntity;
//    }
//
//    public EntityResponse<?> changeUserRoleById(ChangeRoleRequest request) {
//        EntityResponse response = new EntityResponse();
//        Optional<User> existingUser = userRepository.findById(request.getId());
//
//        try {
//            if (existingUser.isPresent()) {
//                User savedUser = existingUser.get();
//                savedUser.setRole(request.getNewRole());
//                userRepository.save(savedUser);
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setEntity(savedUser);
//                response.setMessage("Role changed successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity(null);
//                response.setMessage("User not found");
//            }
//
//        } catch (Exception e) {
//            log.error("Error while changing user role");
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setEntity(null);
//            response.setMessage("Internal server error");
//        }
//        return response;
//    }
//    public EntityResponse<?> changeUserRoleByEmail(ChangeRoleRequest request) {
//        EntityResponse response = new EntityResponse();
//        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
//
//        try {
//            if (existingUser.isPresent()) {
//                User savedUser = existingUser.get();
//                savedUser.setRole(request.getNewRole());
//                userRepository.save(savedUser);
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setEntity(savedUser);
//                response.setMessage("Role changed successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setEntity(null);
//                response.setMessage("User not found");
//            }
//
//        } catch (Exception e) {
//            log.error("Error while changing user role");
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setEntity(null);
//            response.setMessage("Internal server error");
//        }
//        return response;
//    }
//
//
//    @Transactional
//    public EntityResponse deleteUserById(Long id) {
//        EntityResponse responseEntity = new EntityResponse();
//        Optional<User> existingUser = userRepository.findById(id);
//
//        try {
//            if (existingUser.isPresent()) {
//                User deletedUser = existingUser.get();
//
//                log.info("Deleting associated tokens for user with id: {}", id);
//
//                // Manually delete associated tokens
//                tokenRepository.deleteByUserId(id);
//
//                log.info("Tokens deleted successfully for user with id: {}", id);
//                log.info("Deleting user with id: {}", id);
//
//                deletedUser.setDeletedFlag('Y');
//
//                // Now delete the user
//                userRepository.delete(deletedUser);
//
//                log.info("User deleted successfully with id: {}", id);
//
//                responseEntity.setStatusCode(HttpStatus.OK.value());
//                responseEntity.setMessage("User deleted successfully");
//                responseEntity.setEntity(deletedUser);
//            } else {
//                responseEntity.setEntity(null);
//                responseEntity.setMessage("User Not found");
//                responseEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
//            }
//        } catch (Exception e) {
//            log.error("Error while deleting the User with id: {}", id, e);
//            responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            responseEntity.setMessage("INTERNAL SERVER ERROR");
//            responseEntity.setEntity(null);
//        }
//
//        return responseEntity;
//    }
//    private void saveUserToken(User user, String jwtToken) {
//        long currentTimeMillis = System.currentTimeMillis();
//        Date expirationDate = new Date(currentTimeMillis + (10 * 60 * 1000));
//        var token = Token.builder()
//                .user(user)
//                .token(jwtToken)
//                .tokenType(TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .expirationDate(expirationDate)
//                .build();
//        tokenRepository.save(token);
//    }
//    public EntityResponse<?> unlockAccountById(Long id) {
//        EntityResponse<?> response = new EntityResponse<>();
//
//        try {
//            Optional<User> userOpt = userRepository.findById(id);
//            if (userOpt.isPresent()) {
//                User user = userOpt.get();
//
//                // Unlock the account
//                user.resetFailedAttempts();
//                user.unlockAccount();
//
//                // Revoke existing tokens for security (optional but recommended)
//                revokeAllUserTokens(user);
//
//                userRepository.save(user);
//
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setMessage("Account unlocked successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setMessage("User not found");
//            }
//        } catch (Exception e) {
//            log.error("Error while unlocking the user account", e);
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setMessage("Internal server error");
//        }
//
//        return response;
//    }
//    private void revokeAllUserTokens (User user){
//        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//        if (validUserTokens.isEmpty())
//            return;
//        validUserTokens.forEach(token -> {
//            token.setExpired(true);
//            token.setRevoked(true);
//        });
//        tokenRepository.saveAll(validUserTokens);
//    }
//    @Transactional
//    public EntityResponse<?> unlockAccountByEmail(String email) {
//        EntityResponse<?> response = new EntityResponse<>();
//
//        try {
//            Optional<User> userOpt = userRepository.findByEmail(email);
//            if (userOpt.isPresent()) {
//                User user = userOpt.get();
//
//                // Unlock the account
//                user.resetFailedAttempts();
//                user.unlockAccount();
//
//                // Revoke existing tokens for security (optional but recommended)
//                revokeAllUserTokens(user);
//
//                userRepository.save(user);
//
//                response.setStatusCode(HttpStatus.OK.value());
//                response.setMessage("Account unlocked successfully");
//            } else {
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//                response.setMessage("User not found with email: " + email);
//            }
//        } catch (Exception e) {
//            log.error("Error while unlocking the user account", e);
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setMessage("Internal server error");
//        }
//
//        return response;
//    }
//    public List<User> findAllLockedAccounts() {
//        return userRepository.findAllByAccountLockedTrue();
//    }
//
////    private boolean isPasswordComplex(String password) {
////        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$");
////    }
//
//}
