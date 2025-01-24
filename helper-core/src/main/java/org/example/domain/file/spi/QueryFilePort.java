package org.example.domain.file.spi;

import org.example.domain.file.model.File;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.post.model.Post;

import java.util.List;
import java.util.UUID;

public interface QueryFilePort {

    void saveFile(File file);

    void deleteAllByPost(Post post);

    List<FileDataVO> getAllFileByPostId(UUID postId);
}
