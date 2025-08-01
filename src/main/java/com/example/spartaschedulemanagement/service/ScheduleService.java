package com.example.spartaschedulemanagement.service;

import com.example.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.example.spartaschedulemanagement.dto.ScheduleResponse;
import com.example.spartaschedulemanagement.entity.Schedule;
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

    private List<Schedule> getAllScheduleByWriter(String writer) {
        if (false == StringUtils.hasText(writer)) {
            return scheduleRepository.findAllOrderByModifiedAtDesc();
        }

        return scheduleRepository.findAllByWriterOrderByModifiedAtDesc(writer);
    }
}
