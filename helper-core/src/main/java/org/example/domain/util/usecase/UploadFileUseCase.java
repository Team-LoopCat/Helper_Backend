package org.example.domain.util.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.FileService;
import org.example.domain.util.dto.response.UploadFileResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class UploadFileUseCase {
    private final FileService fileService;

    public UploadFileResponseDto execute(MultipartFile file) {
        String fileUrl = fileService.uploadFile(file);
        return new UploadFileResponseDto(fileUrl);
    }
}
