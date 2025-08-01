package com.example.spartaschedulemanagement.api;

import com.example.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.example.spartaschedulemanagement.dto.ScheduleResponse;
import com.example.spartaschedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody CreateScheduleRequest request) {
        ScheduleResponse scheduleResponse = scheduleService.createSchedule(request);
        return new ResponseEntity<>(scheduleResponse, HttpStatus.CREATED);
    }
}
