package com.example.spartaschedulemanagement.dto;

import com.example.spartaschedulemanagement.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String writer;

    public static ScheduleResponse of(Schedule schedule) {
        return new ScheduleResponse(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getWriter());
    }
}
