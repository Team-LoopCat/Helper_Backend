package org.example.domain.test.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.test.dto.vo.AttendDataVo;

import java.util.List;
import java.util.UUID;

public record CreateTestRequestDto(
        @NotBlank String title,
        @NotBlank String content,
        @Min(0) @Max(100) int percent,
        @NotNull UUID subjectId,
        @NotBlank @Valid List<@NotNull AttendDataVo> attends,
        @Valid @Size(max = 3) List<@NotNull FileDataVO> files
) {
}
