package com.subrutin.catalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BookCreateDTO {

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String authorName;

    private String description;
}
