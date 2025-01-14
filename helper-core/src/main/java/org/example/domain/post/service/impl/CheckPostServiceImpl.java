package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.exception.IsNotWriterException;
import org.example.domain.post.exception.PostNotFoundException;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.post.spi.QueryPostPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckPostServiceImpl implements CheckPostService {
    private final QueryPostPort queryPostPort;

    @Override
    public void checkIsWriter(Post post, String studentId) {
        if (!post.getStudentId().equals(studentId)) {
            throw IsNotWriterException.EXCEPTION;
        }
    }

    @Override
    public void checkPostExists(UUID postId) {
        if (!queryPostPort.checkPostExists(postId)) {
            throw PostNotFoundException.EXCEPTION;
        }
    }
}
