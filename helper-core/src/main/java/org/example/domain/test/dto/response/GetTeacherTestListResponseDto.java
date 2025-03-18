package org.example.domain.test.dto.response;

import org.example.domain.test.spi.vo.TestListDataForTeacherVO;

import java.util.List;

public record GetTeacherTestListResponseDto(
        List<TestListDataForTeacherVO> tests
) {
    public GetTeacherTestListResponseDto from(List<TestListDataForTeacherVO> testData) {
        return new GetTeacherTestListResponseDto(testData);
    }
}
