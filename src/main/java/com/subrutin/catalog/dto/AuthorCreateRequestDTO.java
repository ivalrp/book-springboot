package com.subrutin.catalog.dto;

import com.subrutin.catalog.validator.annotation.ValidAuthorName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AuthorCreateRequestDTO {

    @ValidAuthorName
    @NotBlank
    private String authorName;

    @NotNull
    private Long birthDate;

    private List<AddressCreateRequestDTO> addresses;
}
