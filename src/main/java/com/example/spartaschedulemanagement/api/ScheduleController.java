package com.example.spartaschedulemanagement.api;

import com.example.spartaschedulemanagement.dto.*;
import com.example.spartaschedulemanagement.exception.ScheduleNotFoundException;
import com.example.spartaschedulemanagement.service.CommentService;
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
    private final CommentService commentService;

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

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> editScheduleTitleAndWriter(@PathVariable Long scheduleId, @RequestBody EditScheduleTitleAndWriterRequest request) {
        ScheduleResponse scheduleResponse;
        try {
            scheduleResponse = scheduleService.editScheduleTitleAndWriter(scheduleId, request);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteScheduleById(scheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{scheduleId}/comments")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Long scheduleId, @RequestBody CreateCommentRequest request) {
        CommentResponse commentResponse = commentService.addComment(scheduleId, request);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }
}
