package org.example.common.spi;

import org.springframework.web.multipart.MultipartFile;

public interface FilePort {

    String upload(MultipartFile file, String fileName);
}
