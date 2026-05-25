package com.gwuy.sweeto.infra.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "supplier_status", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierStatus {
    @Id
    @Size(max = 20)
    @Column(name = "supplier_status_id", nullable = false, length = 20)
    private String supplierStatusId;

    @Size(max = 50)
    @Column(name = "status_code", length = 50)
    private String statusCode;

    @Size(max = 100)
    @Column(name = "status_name", length = 100)
    private String statusName;

}