package com.example.spartaschedulemanagement.dto;

import com.example.spartaschedulemanagement.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCommentRequest {

    private final String contents;
    private final String writer;
    private final String password;

    public Comment toEntity(Long scheduleId) {
        return Comment.create(scheduleId, contents, writer, password);
    }

}
