package com.example.spartaschedulemanagement.dto;

import com.example.spartaschedulemanagement.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequest {

    private final String title;
    private final String contents;
    private final String writer;
    private final String password;

    public Schedule toEntity() {
        return Schedule.create(title, contents, writer, password);
    }
}
