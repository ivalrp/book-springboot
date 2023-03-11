package com.subrutin.catalog.dto;

import javax.validation.constraints.NotBlank;

public record CategoryCreateUpdateRecordDTO(@NotBlank String code,
                                            @NotBlank String name,
                                            String description) {
}
