package com.example.spartaschedulemanagement.service;

import com.example.spartaschedulemanagement.api.request.CreateScheduleRequest;
import com.example.spartaschedulemanagement.api.request.EditScheduleTitleAndWriterRequest;
import com.example.spartaschedulemanagement.api.response.ScheduleResponse;
import com.example.spartaschedulemanagement.api.response.ScheduleWithCommentsResponse;
import com.example.spartaschedulemanagement.entity.Comment;
import com.example.spartaschedulemanagement.entity.Schedule;
import com.example.spartaschedulemanagement.exception.common.CommonErrorCode;
import com.example.spartaschedulemanagement.exception.InvalidPasswordException;
import com.example.spartaschedulemanagement.exception.ScheduleNotFoundException;
import com.example.spartaschedulemanagement.repository.CommentRepository;
import com.example.spartaschedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public ScheduleResponse createSchedule(final CreateScheduleRequest request) {
        final Schedule schedule = scheduleRepository.save(request.toEntity());
        return ScheduleResponse.of(schedule);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> getAllSchedule(String writer) {
        List<Schedule> schedules = getAllScheduleByWriter(writer);
        return schedules.stream()
                .map(ScheduleResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public ScheduleWithCommentsResponse getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(CommonErrorCode.SCHEDULE_NOT_FOUND));

        List<Comment> comments = commentRepository.findAllByScheduleId(schedule.getId());

        return ScheduleWithCommentsResponse.of(schedule, comments);
    }

    @Transactional
    public ScheduleResponse editScheduleTitleAndWriter(Long id, EditScheduleTitleAndWriterRequest request) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(CommonErrorCode.SCHEDULE_NOT_FOUND));

        if (isInvalidPassword(request, schedule)) {
            throw new InvalidPasswordException(CommonErrorCode.INVALID_PASSWORD);
        }

        schedule.updateTitleAndWriter(request.getTitle(), request.getWriter());
        return ScheduleResponse.of(schedule);
    }

    @Transactional
    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }

    private List<Schedule> getAllScheduleByWriter(String writer) {
        if (false == StringUtils.hasText(writer)) {
            return scheduleRepository.findAllOrderByModifiedAtDesc();
        }

        return scheduleRepository.findAllByWriterOrderByModifiedAtDesc(writer);
    }

    private boolean isInvalidPassword(EditScheduleTitleAndWriterRequest request, Schedule schedule) {
        return !request.getPassword().equals(schedule.getPassword());
    }

}
