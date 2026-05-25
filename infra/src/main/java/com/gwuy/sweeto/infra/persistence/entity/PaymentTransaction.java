package com.gwuy.sweeto.infra.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Entity
@Table(name = "payment_transactions", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentTransaction {
    @Id
    @Size(max = 20)
    @Column(name = "payment_transaction_id", nullable = false, length = 20)
    private String paymentTransactionId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Size(max = 255)
    @Column(name = "transaction_code")
    private String transactionCode;

    @Size(max = 50)
    @Column(name = "provider", length = 50)
    private String provider;

    @Size(max = 50)
    @Column(name = "transaction_status", length = 50)
    private String transactionStatus;

    @Column(name = "transaction_time")
    private Instant transactionTime;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private Map<String, Object> rawPayload;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}