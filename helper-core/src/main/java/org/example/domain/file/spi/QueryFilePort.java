package org.example.domain.file.spi;

import org.example.domain.file.model.File;
import org.example.domain.post.model.Post;

public interface QueryFilePort {

    void saveFile(File file);

    void deleteAllByPost(Post post);
}
