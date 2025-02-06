package org.example.domain.test.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.test.dto.vo.AttendDataVo;

import java.util.UUID;

public record CreateTestRequestDto(
        @NotBlank String title,
        @NotBlank String content,
        @Min(0) @Max(100) int percent,
        UUID subjectId,
        AttendDataVo[] attends,
        FileDataVO[] files
) {
}
