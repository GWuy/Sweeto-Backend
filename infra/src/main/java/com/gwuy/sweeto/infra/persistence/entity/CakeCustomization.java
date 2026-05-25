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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

@Entity
@Table(name = "cake_customizations", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CakeCustomization {
    @Id
    @Size(max = 20)
    @Column(name = "cake_customization_id", nullable = false, length = 20)
    private String cakeCustomizationId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cake_id", nullable = false)
    private Cake cake;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_3d_model_id")
    private Cake3dModel cake3dModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_size_master_id")
    private CakeSizesMaster cakeSizeMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cream_color_id")
    private CreamColor creamColor;

    @Size(max = 255)
    @Column(name = "design_name")
    private String designName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "model_configuration")
    private Map<String, Object> modelConfiguration;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "toppings_configuration")
    private Map<String, Object> toppingsConfiguration;

    @Size(max = 500)
    @Column(name = "text_content", length = 500)
    private String textContent;

    @Column(name = "preview_image_url", length = Integer.MAX_VALUE)
    private String previewImageUrl;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "calculated_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal calculatedPrice;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "is_saved", nullable = false)
    private Boolean isSaved;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}