package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PublisherUpdateRequestDTO implements Serializable {


    private static final long serialVersionUID = 7699115302294881826L;

    private String publisherName;

    private String companyName;

    private String address;

}
