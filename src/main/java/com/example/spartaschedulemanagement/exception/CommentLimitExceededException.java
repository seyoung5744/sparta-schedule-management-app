package com.example.spartaschedulemanagement.exception;

public class CommentLimitExceededException extends RuntimeException {

    public CommentLimitExceededException() {
        super("댓글은 10개 이하까지만 작성 가능합니다.");
    }
}
