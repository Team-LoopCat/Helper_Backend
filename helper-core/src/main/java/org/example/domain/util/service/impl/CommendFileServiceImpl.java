package org.example.domain.util.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.spi.FilePort;
import org.example.domain.util.service.CommendFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CommendFileServiceImpl implements CommendFileService {
    private final FilePort filePort;

    @Override
    public String saveFile(String fileName, MultipartFile file) {
        return filePort.upload(file, fileName);
    }
}
