package com.example.commentservice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @NotEmpty(message = "Comment cannot be empty!")
    @NotNull
    private String content;

    @NotEmpty(message = "Comment cannot be empty!")
    @Column(name = "authorName")
    @NotNull
    private String authorName;

    private LocalDateTime date;

    @Column(name = "blog_id")
    private Long blogId;

}
