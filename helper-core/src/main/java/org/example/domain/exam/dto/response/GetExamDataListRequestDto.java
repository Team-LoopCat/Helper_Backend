package org.example.domain.exam.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.example.domain.exam.spi.vo.SimpleExamDataVO;

public record GetExamDataListRequestDto(
        List<GetExamDataRequestDto> examData
) {
    public static GetExamDataListRequestDto from(List<SimpleExamDataVO> examData) {
        return new GetExamDataListRequestDto(
                examData.stream()
                        .collect(
                                Collectors.groupingBy(
                                        SimpleExamDataVO::examDataId,
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                list -> {
                                                    String teacher = list.stream().map(SimpleExamDataVO::teacher)
                                                            .collect(Collectors.joining(", "));

                                                    SimpleExamDataVO firstVO = list.get(0);

                                                    return new SimpleExamDataVO(
                                                            firstVO.examDataId(),
                                                            firstVO.subject(),
                                                            teacher,
                                                            firstVO.date(),
                                                            firstVO.period(),
                                                            firstVO.problems(),
                                                            firstVO.percent()
                                                    );
                                                }
                                        )
                                )
                        ).values().stream()
                        .map(GetExamDataRequestDto::new)
                        .toList()
        );
    }
}

record GetExamDataRequestDto(
        UUID examDataId,
        String subject,
        String teacher,
        LocalDate date,
        Integer period,
        Integer problems,
        Integer percent
) {

    public GetExamDataRequestDto(SimpleExamDataVO examData) {
        this(
                examData.examDataId(),
                examData.subject(),
                examData.teacher(),
                examData.date(),
                examData.period(),
                examData.problems(),
                examData.percent()
        );
    }
}
