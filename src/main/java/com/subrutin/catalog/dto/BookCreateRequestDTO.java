package com.subrutin.catalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
public class BookCreateRequestDTO implements Serializable {

    private static final long serialVersionUID = -4168927649902160611L;

    @NotBlank
    private String bookTitle;

    @NotEmpty
    private List<String> authorIdList;

    @NotEmpty
    private List<String> categoryList;

    @NotBlank
    private String publisherId;

    private String description;
}
