package com.subrutin.catalog.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorUpdateRequestDTO {

    private String authorName;

    private Long birthDate;

    private List<AddressUpdateRequestDTO> addresses;
}
