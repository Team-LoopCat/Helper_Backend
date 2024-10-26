package org.example.global.thirdparty.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.example.common.spi.FilePort;
import org.example.global.thirdparty.S3.execption.FileIOException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Adapter implements FilePort {
    private final S3Properties properties;
    private final AmazonS3Client amazonS3Client;

    @Override
    public String upload(MultipartFile file, String fileName) {
        saveFile(file, fileName);

        return getFileUrl(fileName);
    }

    private void saveFile(MultipartFile file, String fileName) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            amazonS3Client.putObject(properties.bucket(), fileName, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw FileIOException.EXCEPTION;
        }
    }

    private String getFileUrl(String fileName) {
        return amazonS3Client.getUrl(properties.bucket(), fileName).toString();
    }
}
