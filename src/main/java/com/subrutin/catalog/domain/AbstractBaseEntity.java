package com.subrutin.catalog.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "author", indexes = {
        @Index(name = "uk_secure_id", columnList = "secure_id")
})
@Data
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {


    private static final long serialVersionUID = -2119574796403647424L;

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted;
}
