package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryListResponseDTO implements Serializable {

    private static final long serialVersionUID = -9145132319388794342L;

    private String code;

    private String name;

    private String description;
}
