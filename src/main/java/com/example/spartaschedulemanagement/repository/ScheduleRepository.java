package com.example.spartaschedulemanagement.repository;

import com.example.spartaschedulemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByWriterOrderByModifiedAtDesc(String writer);

    @Query("select s from Schedule s order by s.modifiedAt DESC")
    List<Schedule> findAllOrderByModifiedAtDesc();
}
