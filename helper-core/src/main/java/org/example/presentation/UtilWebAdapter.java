package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.util.dto.response.UploadFileResponseDto;
import org.example.domain.util.usecase.UploadFileUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/util")
public class UtilWebAdapter {
    private final UploadFileUseCase uploadFileUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/file")
    public UploadFileResponseDto uploadFile(@RequestPart("file") MultipartFile file) {
        return uploadFileUseCase.execute(file);
    }
}
