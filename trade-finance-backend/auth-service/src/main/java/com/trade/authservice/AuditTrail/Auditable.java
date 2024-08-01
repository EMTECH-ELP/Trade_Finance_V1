package com.trade.authservice.AuditTrail;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<String> {
    @CreatedBy
    protected String createdBy;
    @CreatedDate
    @Column(nullable = false,
            updatable = false)
    protected LocalDateTime createdDate;
    @LastModifiedBy
    protected String lastModifiedBy;
    @LastModifiedDate
    @Column(insertable = false)
    protected LocalDateTime lastModifiedDate;
}

