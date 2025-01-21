package org.example.domain.post.dto.response;

import org.example.domain.comment.spi.vo.CommentDataVO;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.post.dto.vo.PostDataVO;
import org.example.domain.comment.spi.vo.ReplyDataVO;

import java.util.List;

public record GetPostDetailResponseDto(
    PostDataVO post,
    List<CommentDataVO> comments,
    List<ReplyDataVO> replies,
    List<FileDataVO> files
) {
}
