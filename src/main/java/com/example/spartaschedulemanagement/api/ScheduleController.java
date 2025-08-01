package com.example.spartaschedulemanagement.api;

import com.example.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.example.spartaschedulemanagement.dto.ScheduleResponse;
import com.example.spartaschedulemanagement.exception.ScheduleNotFoundException;
import com.example.spartaschedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        ScheduleResponse scheduleResponse = scheduleService.createSchedule(request);
        return new ResponseEntity<>(scheduleResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllSchedule(@RequestParam(required = false) String writer) {
        List<ScheduleResponse> scheduleResponses = scheduleService.getAllSchedule(writer);
        return new ResponseEntity<>(scheduleResponses, HttpStatus.OK);
    }

    @GetMapping("/{scheduleId}")
    private ResponseEntity<ScheduleResponse> getSchedule(@PathVariable Long scheduleId) {
        ScheduleResponse scheduleResponse;
        try {
            scheduleResponse = scheduleService.getScheduleById(scheduleId);
        } catch (ScheduleNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scheduleResponse, HttpStatus.OK);
    }
}
