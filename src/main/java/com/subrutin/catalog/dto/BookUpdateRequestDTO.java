package com.subrutin.catalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BookUpdateRequestDTO {

    @NotBlank
    private String bookTitle;

    private String description;

}
