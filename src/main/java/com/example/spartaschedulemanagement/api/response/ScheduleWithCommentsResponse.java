package com.example.spartaschedulemanagement.api.response;

import com.example.spartaschedulemanagement.entity.Comment;
import com.example.spartaschedulemanagement.entity.Schedule;
import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleWithCommentsResponse {

    private final ScheduleResponse schedule;
    private final List<CommentResponse> comments;

    private ScheduleWithCommentsResponse(ScheduleResponse schedule, List<CommentResponse> comments) {
        this.schedule = schedule;
        this.comments = comments;
    }

    public static ScheduleWithCommentsResponse of(Schedule schedule, List<Comment> comments) {
        return new ScheduleWithCommentsResponse(
                ScheduleResponse.of(schedule),
                comments.stream()
                        .map(CommentResponse::of)
                        .toList()
        );
    }
}
