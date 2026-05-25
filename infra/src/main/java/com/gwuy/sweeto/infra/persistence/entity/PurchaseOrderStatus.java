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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "purchase_order_status", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseOrderStatus {
    @Id
    @Size(max = 20)
    @Column(name = "purchase_order_status_id", nullable = false, length = 20)
    private String purchaseOrderStatusId;

    @Size(max = 50)
    @NotNull
    @Column(name = "status_code", nullable = false, length = 50)
    private String statusCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "status_name", nullable = false, length = 100)
    private String statusName;

}