package org.example.domain.test.dto.response;

import org.example.domain.test.spi.vo.TestListDataForStudentVO;

import java.util.List;

public record GetTestListForStudentResponseDto(
        List<TestListDataForStudentVO> tests
) {
    public static GetTestListForStudentResponseDto from(List<TestListDataForStudentVO> testDataList) {
        return new GetTestListForStudentResponseDto(testDataList);
    }
}
