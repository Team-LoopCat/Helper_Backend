package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.comment.service.GetReplyService;
import org.example.domain.file.service.GetFileService;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.post.dto.response.GetPostDetailResponseDto;
import org.example.domain.comment.spi.vo.CommentDataVO;
import org.example.domain.post.dto.vo.PostDataVO;
import org.example.domain.comment.spi.vo.ReplyDataVO;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.GetPostService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPostDetailUseCase {
    private final GetPostService getPostService;
    private final GetStudentService getStudentService;
    private final GetCommentService getCommentService;
    private final GetReplyService getReplyService;
    private final GetFileService getFileService;

    public GetPostDetailResponseDto execute(UUID postId) {
        Post post = getPostService.getPostByPostId(postId);
        Student postWriter =  getStudentService.getStudentByStudentId(post.getStudentId());
        PostDataVO postData = PostDataVO.of(postWriter, post);

        List<CommentDataVO> commentDataVOList = getCommentService.getAllCommentsWithWritersByPost(postId);
        List<ReplyDataVO> replyDataVOList = new ArrayList<>();
        for (CommentDataVO commentData: commentDataVOList) {
            replyDataVOList.addAll(
                    getReplyService.getAllRepliesByComment(commentData.commentId())
            );
        }
        List<FileDataVO> fileDataVOList = getFileService.getAllFileByPostId(postId);

        return new GetPostDetailResponseDto(postData, commentDataVOList, replyDataVOList, fileDataVOList);
    }
}
