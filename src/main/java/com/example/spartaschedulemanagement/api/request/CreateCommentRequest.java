package com.example.spartaschedulemanagement.api.request;

import com.example.spartaschedulemanagement.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCommentRequest {

    @NotBlank(message = "댓글 내용은 필수입니다.")
    @Size(min = 1, max = 100, message = "댓글 내용은 최대 100자까지 입력 가능합니다.")
    private final String contents;

    @NotBlank(message = "작성자는 필수입니다.")
    private final String writer;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private final String password;

    public Comment toEntity(Long scheduleId) {
        return Comment.create(scheduleId, contents, writer, password);
    }

}
