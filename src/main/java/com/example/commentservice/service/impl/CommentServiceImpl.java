package com.example.commentservice.service.impl;

import com.example.commentservice.exception.NotFoundException;
import com.example.commentservice.model.Comment;
import com.example.commentservice.repository.CommentRepository;
import com.example.commentservice.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        comment.setDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isEmpty()) {
            log.info("Comment with id {} was not found", commentId);
            throw new NotFoundException("Comment not found");
        }
        return commentOptional.get();
    }

    @Override
    public List<Comment> findByBlogId(Long blogId) {
        return commentRepository.findCommentByBlogId(blogId);
    }

    @Override
    public void deleteById(Long commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isEmpty()) {
            log.info("Comment with id {} was not found", commentId);
            throw new NotFoundException("Comment not found");
        }
        commentRepository.delete(commentOptional.get());
    }
}
