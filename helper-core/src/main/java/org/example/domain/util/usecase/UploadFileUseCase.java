package org.example.domain.util.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.util.dto.response.FileUploadResponseDto;
import org.example.domain.util.service.CommendFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UploadFileUseCase {
    private final CommendFileService commendFileService;

    public FileUploadResponseDto execute(MultipartFile file) {
        String fileName = UUID.randomUUID() + file.getOriginalFilename();

        return new FileUploadResponseDto(
                commendFileService.saveFile(fileName, file)
        );
    }
}
