package org.example.domain.file.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.service.GetFileService;
import org.example.domain.file.spi.QueryFilePort;
import org.example.domain.file.spi.vo.FileDataVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetFileServiceImpl implements GetFileService {
    private final QueryFilePort queryFilePort;

    @Override
    public List<FileDataVO> getAllFileByPostId(UUID postId) {
        return queryFilePort.getAllFileByPostId(postId);
    }
}
