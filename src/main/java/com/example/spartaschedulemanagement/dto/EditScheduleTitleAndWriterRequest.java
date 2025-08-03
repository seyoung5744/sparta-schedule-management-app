package com.example.spartaschedulemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditScheduleTitleAndWriterRequest {

    @NotBlank(message = "일정 제목은 필수입니다.")
    @Size(min = 1, max = 30, message = "일정 제목은 최대 30자까지 입력 가능합니다.")
    private final String title;

    @NotBlank(message = "작성자명은 필수입니다.")
    private final String writer;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private final String password;
}
