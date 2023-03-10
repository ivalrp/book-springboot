package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressUpdateRequestDTO implements Serializable {
    private static final long serialVersionUID = 8144886430098553754L;

    private Long addressId;

    private String streetName;

    private String cityName;

    private String zipCode;
}
