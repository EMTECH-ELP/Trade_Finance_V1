package com.trade.authservice.OTP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Service
public class OTPService {
    private final OTPRepository otpRepository;

    public OTPService(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public String generateOtp(String email) {
        int otp = 1000 + new Random().nextInt(9000);

        OTP otpEntity = new OTP();
        otpEntity.setOtp(otp);
        otpEntity.setRequestedTime(LocalDateTime.now());
        otpEntity.setEmail(email);

        otpRepository.save(otpEntity);

        log.info("Generated OTP: {}", otp);
        return String.valueOf(otp);
    }
}
