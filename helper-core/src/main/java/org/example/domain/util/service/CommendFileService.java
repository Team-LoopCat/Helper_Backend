package org.example.domain.util.service;


import org.springframework.web.multipart.MultipartFile;

public interface CommendFileService {

    String saveFile(String fileName, MultipartFile file);
}
