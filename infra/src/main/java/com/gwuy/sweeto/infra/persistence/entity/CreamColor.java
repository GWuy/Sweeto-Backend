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
@Table(name = "cream_colors", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreamColor {
    @Id
    @Size(max = 20)
    @Column(name = "cream_color_id", nullable = false, length = 20)
    private String creamColorId;

    @Size(max = 50)
    @NotNull
    @Column(name = "color_code", nullable = false, length = 50)
    private String colorCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "color_name", nullable = false, length = 100)
    private String colorName;

    @Size(max = 20)
    @Column(name = "hex_code", length = 20)
    private String hexCode;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}