package org.example.domain.file.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.model.File;
import org.example.domain.file.service.CommendFileService;
import org.example.domain.file.spi.QueryFilePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommendFileServiceImpl implements CommendFileService {
    private final QueryFilePort queryFilePort;

    @Override
    public void saveFile(File file) {
        queryFilePort.saveFile(file);
    }
}
