package com.subrutin.catalog.dto;

import com.subrutin.catalog.enums.ErrorCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponseDTO implements Serializable {

    private static final long serialVersionUID = 5074484809403669488L;

    private Date timeStamp;

    private String message;

    private ErrorCode errorCode;

    private List<String> details;

    private HttpStatus httpStatus;

    public static ErrorResponseDTO of(final String message, List<String> details,
                                      final ErrorCode errorCode, HttpStatus httpStatus){
        return new ErrorResponseDTO(message, errorCode, details, httpStatus);
    }

    public ErrorResponseDTO(String message, ErrorCode errorCode, List<String> details, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.httpStatus = httpStatus;
        this.timeStamp = new Date();
    }
}
