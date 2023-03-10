package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressCreateRequestDTO implements Serializable {

    private static final long serialVersionUID = 143798554481955393L;

    private String streetName;

    private String cityName;

    private String zipCode;
}
