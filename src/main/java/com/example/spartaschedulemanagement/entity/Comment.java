package com.example.spartaschedulemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long scheduleId;

    private String contents;
    private String writer;
    private String password;

    @Builder
    private Comment(Long scheduleId, String contents, String writer, String password) {
        this.scheduleId = scheduleId;
        this.contents = contents;
        this.writer = writer;
        this.password = password;
    }

    public static Comment create(Long scheduleId, String contents, String writer, String password) {
        return Comment.builder()
                .scheduleId(scheduleId)
                .contents(contents)
                .writer(writer)
                .password(password)
                .build();
    }

}
