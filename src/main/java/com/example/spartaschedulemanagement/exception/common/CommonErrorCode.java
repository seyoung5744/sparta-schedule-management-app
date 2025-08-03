package com.example.spartaschedulemanagement.exception.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 일정은 존재하지 않습니다."),
    COMMENT_LIMIT_EXCEEDED(HttpStatus.BAD_REQUEST, "댓글은 최대 10개까지만 작성할 수 있습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

}
