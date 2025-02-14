package org.example.persistence.file.repository;

import java.util.List;
import java.util.UUID;

import org.example.domain.file.spi.vo.FileDataVO;
import org.example.persistence.file.entity.FileJpaEntity;
import org.example.persistence.post.entity.PostJpaEntity;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FileJpaRepository extends CrudRepository<FileJpaEntity, UUID> {

    void deleteAllByPost(PostJpaEntity post);

    void deleteAllByTest(TestJpaEntity entity);

    @Query("SELECT " +
            "NEW org.example.domain.file.spi.vo.FileDataVO(f.filename, f.url) " +
            "FROM file f " +
            "WHERE f.post.postId = :postId")
    List<FileDataVO> findAllByPostId(@Param("postId") UUID postId);
}
