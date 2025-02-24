package org.example.domain.test.dto.response;

import org.example.domain.test.spi.vo.TestListForTeacherDataVO;

import java.util.List;

public record GetTeacherTestListResponseDto(
        List<TestListForTeacherDataVO> tests
) {
    public GetTeacherTestListResponseDto from(List<TestListForTeacherDataVO> testData) {
        return new GetTeacherTestListResponseDto(testData);
    }
}
