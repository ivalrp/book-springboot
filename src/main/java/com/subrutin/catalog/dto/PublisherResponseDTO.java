package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PublisherResponseDTO implements Serializable {

    private static final long serialVersionUID = 1666799028361503954L;

    private String publisherId;

    public String publisherName;
}
