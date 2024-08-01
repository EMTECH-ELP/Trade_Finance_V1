package com.trade.authservice.AuditTrail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditTrailService {
    @Autowired
    private AuditTrailRepository auditTrailRepository;

    public void logEvent(String eventType, String administrator, String user, String ipAddress, String actionDetails, boolean success) {
        AuditTrail auditTrail = new AuditTrail();
        auditTrail.setEventType(eventType);
        auditTrail.setTimestamp(LocalDateTime.now());
        auditTrail.setAdministrator(administrator);
        auditTrail.setUser(user);
        auditTrail.setIpAddress(ipAddress);
        auditTrail.setActionDetails(actionDetails);
        auditTrail.setSuccess(success);

        auditTrailRepository.save(auditTrail);
    }
}