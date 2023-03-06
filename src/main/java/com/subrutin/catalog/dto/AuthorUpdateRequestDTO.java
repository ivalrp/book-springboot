package com.subrutin.catalog.dto;

import lombok.Data;

@Data
public class AuthorUpdateRequestDTO {

    private String authorName;

    private Long birthDate;
}
