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

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "cakes", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cake {
    @Id
    @Size(max = 20)
    @Column(name = "cake_id", nullable = false, length = 20)
    private String cakeId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cake_status_id", nullable = false)
    private CakeStatus cakeStatus;

    @Size(max = 255)
    @NotNull
    @Column(name = "cake_name", nullable = false)
    private String cakeName;

    @Size(max = 500)
    @Column(name = "short_description", length = 500)
    private String shortDescription;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @Column(name = "base_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal basePrice;

    @Column(name = "preparation_time_minutes")
    private Integer preparationTimeMinutes;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "average_rating", nullable = false, precision = 3, scale = 2)
    private BigDecimal averageRating;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "total_reviews", nullable = false)
    private Integer totalReviews;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "is_customizable", nullable = false)
    private Boolean isCustomizable;

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