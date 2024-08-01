package com.trade.authservice.Register;

import com.trade.authservice.OTP.OTPCode;
import com.trade.authservice.OTP.OTPResponse;
import com.trade.authservice.utils.EntityResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/registerAdmin")
//    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public EntityResponse<RegisterResponse> registerAdmin(@RequestBody RegisterRequest request) {
        return authenticationService.registerAdmin(request);
    }
    @PostMapping("/login")
    public EntityResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return authenticationService.authenticateUser(request);
    }
    @PostMapping("/logout")
    public EntityResponse<?> logout(@RequestBody SignOutRequest signOutRequest){
        return authenticationService.logout(signOutRequest);
    }

    @PostMapping("/validateOtp")
    public EntityResponse<OTPResponse> validateOTP(@RequestBody OTPCode otpCode){
        return authenticationService.validateOTP(otpCode);
    }
//    @PostMapping("/forgot/Password")
//    public EntityResponse<?> forgotPassword(@RequestBody ForgotPassword forgotPassword) throws MessagingException, IOException {
//        return authenticationService.forgotPassword(forgotPassword);
//    }


}
