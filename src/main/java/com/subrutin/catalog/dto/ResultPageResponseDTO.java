package com.subrutin.catalog.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultPageResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 8968668353875569332L;

    private List<T> result;

    private Integer pages;

    private Long elements;
}
