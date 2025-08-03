package com.example.spartaschedulemanagement.dto;

import com.example.spartaschedulemanagement.entity.Schedule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequest {

    @NotBlank(message = "일정 제목은 필수입니다.")
    @Size(min = 1, max = 30, message = "일정 제목은 최대 30자까지 입력 가능합니다.")
    private final String title;

    @NotBlank(message = "일정 내용은 필수입니다.")
    @Size(min = 1, max = 200, message = "일정 내용은 최대 200자까지 입력 가능합니다.")
    private final String contents;

    @NotBlank(message = "작성자명은 필수입니다.")
    private final String writer;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private final String password;

    public Schedule toEntity() {
        return Schedule.create(title, contents, writer, password);
    }
}
