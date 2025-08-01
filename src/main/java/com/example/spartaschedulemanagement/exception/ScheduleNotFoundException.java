package com.example.spartaschedulemanagement.exception;

public class ScheduleNotFoundException extends RuntimeException {

    public ScheduleNotFoundException(Long id) {
        super(id + "는 존재하지 않은 일정입니다.");
    }
}
