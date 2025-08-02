package com.example.spartaschedulemanagement.dto;

import com.example.spartaschedulemanagement.entity.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponse {

    private final Long id;
    private final String contents;
    private final String writer;

    @Builder
    private CommentResponse(Long id, String contents, String writer) {
        this.id = id;
        this.contents = contents;
        this.writer = writer;
    }

    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .contents(comment.getContents())
                .writer(comment.getWriter())
                .build();
    }
}
