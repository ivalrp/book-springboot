package com.subrutin.catalog.dto;

import com.subrutin.catalog.annotation.LogThisArg;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@LogThisArg
public class PublisherCreateRequestDTO implements Serializable {

    private static final long serialVersionUID = 6264675048939616940L;

    @NotBlank(message = "publisher.must.not.blank")
    private String publisherName;

    @NotBlank(message = "company.must.not.blank")
    private String companyName;

    private String address;
}
