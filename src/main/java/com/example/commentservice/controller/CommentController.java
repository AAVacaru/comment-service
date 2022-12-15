package com.example.commentservice.controller;

import com.example.commentservice.model.Comment;
import com.example.commentservice.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/comment-service/blogs/")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/{blogId}/comments")
    public ResponseEntity<Comment> saveComment(@PathVariable Long blogId, @RequestBody Comment comment) {
        comment.setBlogId(blogId);
        Comment savedComment = commentService.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{blogId}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByBlogId(@PathVariable Long blogId) {
        List<Comment> comments = commentService.findByBlogId(blogId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<Comment> getAllCommentsById(@PathVariable Long commentId) {
        Comment comment = commentService.findById(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
