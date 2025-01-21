package org.example.domain.file.service;

import org.example.domain.file.spi.vo.FileDataVO;

import java.util.List;
import java.util.UUID;

public interface GetFileService {
    List<FileDataVO> getAllFileByPostId(UUID postId);
}
