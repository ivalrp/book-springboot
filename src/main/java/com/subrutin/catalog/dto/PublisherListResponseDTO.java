package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PublisherListResponseDTO implements Serializable {

    private static final long serialVersionUID = 8060672199662256692L;

    private String publisherId;

    private String publisherName;

    private String companyName;
}
