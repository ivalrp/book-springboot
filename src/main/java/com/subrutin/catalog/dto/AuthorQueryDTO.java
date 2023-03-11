package com.subrutin.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthorQueryDTO {

    private Long bookId;

    private String authorName;
}
