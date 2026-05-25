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

import java.time.Instant;

@Entity
@Table(name = "addresses", schema = "sweeto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    @Id
    @Size(max = 20)
    @Column(name = "address_id", nullable = false, length = 20)
    private String addressId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Size(max = 20)
    @NotNull
    @Column(name = "receiver_phone", nullable = false, length = 20)
    private String receiverPhone;

    @Size(max = 100)
    @NotNull
    @Column(name = "province", nullable = false, length = 100)
    private String province;

    @Size(max = 100)
    @NotNull
    @Column(name = "district", nullable = false, length = 100)
    private String district;

    @Size(max = 100)
    @NotNull
    @Column(name = "ward", nullable = false, length = 100)
    private String ward;

    @NotNull
    @Column(name = "address_line", nullable = false, length = Integer.MAX_VALUE)
    private String addressLine;

    @Size(max = 20)
    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @NotNull
    @ColumnDefault("false")
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}