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
import java.time.Instant;

@Entity
@Table(name = "ingredients", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient {
    @Id
    @Size(max = 20)
    @Column(name = "ingredient_id", nullable = false, length = 20)
    private String ingredientId;

    @Size(max = 255)
    @NotNull
    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Size(max = 50)
    @NotNull
    @Column(name = "unit", nullable = false, length = 50)
    private String unit;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "minimum_stock", nullable = false, precision = 12, scale = 2)
    private BigDecimal minimumStock;

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