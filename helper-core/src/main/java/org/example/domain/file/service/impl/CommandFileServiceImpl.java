package org.example.domain.file.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.model.File;
import org.example.domain.file.service.CommandFileService;
import org.example.domain.file.spi.QueryFilePort;
import org.example.domain.post.model.Post;
import org.example.domain.test.model.Test;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandFileServiceImpl implements CommandFileService {
    private final QueryFilePort queryFilePort;

    @Override
    public void saveFile(File file) {
        queryFilePort.saveFile(file);
    }

    @Override
    public void deleteAllByPost(Post post) {
        queryFilePort.deleteAllByPost(post);
    }

    @Override
    public void deleteAllByTest(Test test) {
        queryFilePort.deleteAllByTest(test);
    }
}
