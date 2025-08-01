package com.example.spartaschedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String password;

    @Builder
    private Schedule(String title, String contents, String writer, String password) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.password = password;
    }

    public static Schedule create(String title, String contents, String writer, String password) {
        return Schedule.builder()
                .title(title)
                .contents(contents)
                .writer(writer)
                .password(password)
                .build();
    }
}
