package org.example.domain.test.dto.response;

import org.example.domain.test.spi.vo.TeacherTestListDataVO;

import java.util.List;

public record GetTeacherTestListResponseDto(
        List<TeacherTestListDataVO> tests
) {
    public GetTeacherTestListResponseDto from(List<TeacherTestListDataVO> testData) {
        return new GetTeacherTestListResponseDto(testData);
    }
}
