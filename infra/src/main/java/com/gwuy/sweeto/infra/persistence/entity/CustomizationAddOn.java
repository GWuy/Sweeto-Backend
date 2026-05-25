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
import java.time.Instant;

@Entity
@Table(name = "customization_add_ons", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomizationAddOn {
    @Id
    @Size(max = 20)
    @Column(name = "customization_add_on_id", nullable = false, length = 20)
    private String customizationAddOnId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cake_customization_id", nullable = false)
    private CakeCustomization cakeCustomization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topping_id")
    private Topping topping;

    @Size(max = 255)
    @Column(name = "decoration_name")
    private String decorationName;

    @Column(name = "position_x", precision = 12, scale = 4)
    private BigDecimal positionX;

    @Column(name = "position_y", precision = 12, scale = 4)
    private BigDecimal positionY;

    @Column(name = "position_z", precision = 12, scale = 4)
    private BigDecimal positionZ;

    @Column(name = "rotation_x", precision = 12, scale = 4)
    private BigDecimal rotationX;

    @Column(name = "rotation_y", precision = 12, scale = 4)
    private BigDecimal rotationY;

    @Column(name = "rotation_z", precision = 12, scale = 4)
    private BigDecimal rotationZ;

    @Column(name = "scale_factor", precision = 12, scale = 4)
    private BigDecimal scaleFactor;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "extra_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal extraPrice;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}