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

import java.time.Instant;
import java.util.Map;

@Entity
@Table(name = "cake_3d_models", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cake3dModel {
    @Id
    @Size(max = 20)
    @Column(name = "cake_3d_model_id", nullable = false, length = 20)
    private String cake3dModelId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cake_id", nullable = false)
    private Cake cake;

    @Size(max = 255)
    @NotNull
    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Size(max = 20)
    @NotNull
    @Column(name = "model_format", nullable = false, length = 20)
    private String modelFormat;

    @Column(name = "model_url", length = Integer.MAX_VALUE)
    private String modelUrl;

    @Column(name = "model_binary")
    private byte[] modelBinary;

    @Column(name = "thumbnail_url", length = Integer.MAX_VALUE)
    private String thumbnailUrl;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "model_metadata")
    private Map<String, Object> modelMetadata;

    @NotNull
    @ColumnDefault("false")
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

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