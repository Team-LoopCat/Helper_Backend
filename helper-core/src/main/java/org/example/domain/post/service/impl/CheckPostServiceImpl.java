package org.example.domain.post.service.impl;

import org.example.domain.post.exception.IsNotWriterException;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.springframework.stereotype.Service;

@Service
public class CheckPostServiceImpl implements CheckPostService {

    @Override
    public void checkIsWriter(Post post, String studentId) {
        if (!post.getStudentId().equals(studentId)) {
            throw IsNotWriterException.EXCEPTION;
        }
    }
}
