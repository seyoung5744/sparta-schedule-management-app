package com.example.spartaschedulemanagement.repository;

import com.example.spartaschedulemanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
