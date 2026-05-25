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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "cake_sizes", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CakeSize {
    @Id
    @Size(max = 20)
    @Column(name = "cake_size_id", nullable = false, length = 20)
    private String cakeSizeId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cake_id", nullable = false)
    private Cake cake;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cake_size_master_id", nullable = false)
    private CakeSizesMaster cakeSizeMaster;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "additional_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal additionalPrice;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

}