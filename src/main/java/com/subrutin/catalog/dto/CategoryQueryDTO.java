package com.subrutin.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoryQueryDTO {

    private Long bookId;

    private String categoryCode;
}
