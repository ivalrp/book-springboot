package com.subrutin.catalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AuthorCreateRequestDTO {

    @NotBlank
    private String authorName;

    @NotNull
    private Long birthDate;
}
