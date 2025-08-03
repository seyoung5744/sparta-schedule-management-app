package com.example.spartaschedulemanagement.exception;

import com.example.spartaschedulemanagement.exception.common.CommonErrorCode;
import com.example.spartaschedulemanagement.exception.common.GlobalException;

public class CommentLimitExceededException extends GlobalException {

    public CommentLimitExceededException(CommonErrorCode errorCode) {
        super(errorCode);
    }
}
