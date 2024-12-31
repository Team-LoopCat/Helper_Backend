package org.example.global.thirdparty.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.example.common.service.FileService;
import org.example.global.thirdparty.S3.exception.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileAdapter implements FileService {
    @Value("${cloud.aws.bucket}")
    private String bucket;

    private final AmazonS3Client amazonS3Client;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename() + UUID.randomUUID();

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), objectMetadata);

            return amazonS3Client.getResourceUrl(bucket, fileName);
        } catch (Exception e) {
            throw FileUploadException.EXCEPTION;
        }
    }
}
