package com.trade.authservice.OTP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {
    @Query(value = "SELECT * FROM otp WHERE email = :email AND req_time >= :time ORDER BY req_time DESC LIMIT 1", nativeQuery = true)
    OTP validOTP(@Param("email") String email, @Param("time") LocalDateTime time);
}
