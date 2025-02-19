package org.example.domain.test.dto.response;

import org.example.domain.test.spi.vo.TestListDataVO;

import java.util.List;

public record GetTeacherTestListResponseDto(
        List<TestListDataVO> tests
) {
    public GetTeacherTestListResponseDto of(List<TestListDataVO> testData) {
        return new GetTeacherTestListResponseDto(testData);
    }
}
