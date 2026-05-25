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

import java.time.Instant;

@Entity
@Table(name = "suppliers", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supplier {
    @Id
    @Size(max = 20)
    @Column(name = "supplier_id", nullable = false, length = 20)
    private String supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_status_id")
    private SupplierStatus supplierStatus;

    @Size(max = 255)
    @NotNull
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Size(max = 50)
    @Column(name = "tax_code", length = 50)
    private String taxCode;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}