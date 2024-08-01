package com.TradeFinance.documentsservice.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Long> {

    Optional<Documents> findById(Long documentId);
}
