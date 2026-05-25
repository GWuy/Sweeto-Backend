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
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "order_status", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderStatus {
    @Id
    @Size(max = 20)
    @Column(name = "order_status_id", nullable = false, length = 20)
    private String orderStatusId;

    @Size(max = 50)
    @NotNull
    @Column(name = "status_code", nullable = false, length = 50)
    private String statusCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "status_name", nullable = false, length = 100)
    private String statusName;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

}