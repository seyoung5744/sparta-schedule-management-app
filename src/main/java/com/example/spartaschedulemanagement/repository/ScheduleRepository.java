package com.example.spartaschedulemanagement.repository;

import com.example.spartaschedulemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
