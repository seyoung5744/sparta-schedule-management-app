package com.example.spartaschedulemanagement.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteScheduleRequest {

    @NotBlank(message = "일정 삭제 시 비밀번호는 필수입니다.")
    private final String password;

}
