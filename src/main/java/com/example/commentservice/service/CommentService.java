package com.example.commentservice.service;

import com.example.commentservice.model.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);

    Comment findById(Long commentId);

    List<Comment> findByBlogId(Long blogId);

    void deleteById(Long commentId);
}
