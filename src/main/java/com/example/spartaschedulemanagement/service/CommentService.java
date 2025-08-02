package com.example.spartaschedulemanagement.service;

import com.example.spartaschedulemanagement.dto.CommentResponse;
import com.example.spartaschedulemanagement.dto.CreateCommentRequest;
import com.example.spartaschedulemanagement.entity.Comment;
import com.example.spartaschedulemanagement.entity.Schedule;
import com.example.spartaschedulemanagement.exception.CommentLimitExceededException;
import com.example.spartaschedulemanagement.exception.ScheduleNotFoundException;
import com.example.spartaschedulemanagement.repository.CommentRepository;
import com.example.spartaschedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentResponse addComment(final Long scheduleId, final CreateCommentRequest request) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleNotFoundException(scheduleId));

        if (schedule.hasMaxCommentCount()) {
            throw new CommentLimitExceededException();
        }

        schedule.increaseCommentCount();
        Comment comment = commentRepository.save(request.toEntity(scheduleId));

        return CommentResponse.of(comment);
    }

}
