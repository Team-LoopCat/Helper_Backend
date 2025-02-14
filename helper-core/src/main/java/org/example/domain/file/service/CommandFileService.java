package org.example.domain.file.service;

import org.example.domain.file.model.File;
import org.example.domain.post.model.Post;
import org.example.domain.test.model.Test;

public interface CommandFileService {

    void saveFile(File file);

    void deleteAllByPost(Post post);

    void deleteAllByTest(Test test);
}
