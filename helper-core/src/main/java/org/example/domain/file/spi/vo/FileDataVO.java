package org.example.domain.file.spi.vo;

import jakarta.validation.constraints.NotBlank;

public record FileDataVO(
        @NotBlank String file,
        @NotBlank String fileName
) {
}
