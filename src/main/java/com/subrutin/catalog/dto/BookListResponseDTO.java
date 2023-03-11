package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BookListResponseDTO implements Serializable {

    private static final long serialVersionUID = -9131456948434749433L;

    private String id;

    private String title;

    private String description;

    private String publisherName;

    private List<String> categoryCode;

    private List<String> authorName;
}
