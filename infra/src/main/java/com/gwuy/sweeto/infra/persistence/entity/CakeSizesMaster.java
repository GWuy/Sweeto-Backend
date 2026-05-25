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

import java.math.BigDecimal;

@Entity
@Table(name = "cake_sizes_master", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CakeSizesMaster {
    @Id
    @Size(max = 20)
    @Column(name = "cake_size_master_id", nullable = false, length = 20)
    private String cakeSizeMasterId;

    @Size(max = 50)
    @NotNull
    @Column(name = "size_code", nullable = false, length = 50)
    private String sizeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "size_name", nullable = false, length = 100)
    private String sizeName;

    @Column(name = "diameter_cm")
    private Integer diameterCm;

    @Column(name = "serves_people")
    private Integer servesPeople;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "additional_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal additionalPrice;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}