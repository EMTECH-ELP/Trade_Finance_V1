package com.TradeLoans.InvoiceDiscounting.repository;

import com.TradeLoans.InvoiceDiscounting.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Applicant> findByAccountNumber(String accountNumber);
    Optional<Applicant> findByCifId(String cifId);
    Optional<Applicant> findByAccountName(String accountName);
    Optional<Applicant> findByEmail(String email);
    Optional<Applicant> findByNationalId(String nationalId);
}

