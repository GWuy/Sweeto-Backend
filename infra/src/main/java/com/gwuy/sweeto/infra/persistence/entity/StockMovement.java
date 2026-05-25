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
@Table(name = "stock_movements", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockMovement {
    @Id
    @Size(max = 20)
    @Column(name = "stock_movement_id", nullable = false, length = 20)
    private String stockMovementId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_batch_id")
    private StockBatch stockBatch;

    @Size(max = 20)
    @NotNull
    @Column(name = "movement_type", nullable = false, length = 20)
    private String movementType;

    @NotNull
    @Column(name = "quantity", nullable = false, precision = 12, scale = 2)
    private BigDecimal quantity;

    @Size(max = 50)
    @Column(name = "reference_type", length = 50)
    private String referenceType;

    @Size(max = 20)
    @Column(name = "reference_id", length = 20)
    private String referenceId;

    @Column(name = "note", length = Integer.MAX_VALUE)
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moved_by_account_id")
    private Account movedByAccount;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}