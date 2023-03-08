package com.subrutin.catalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class CategoryCreateRequestDTO implements Serializable {


    private static final long serialVersionUID = 7477428048250879182L;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;
}
