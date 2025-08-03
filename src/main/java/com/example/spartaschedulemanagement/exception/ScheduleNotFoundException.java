package com.example.spartaschedulemanagement.exception;

import com.example.spartaschedulemanagement.exception.common.CommonErrorCode;
import com.example.spartaschedulemanagement.exception.common.GlobalException;

public class ScheduleNotFoundException extends GlobalException {

    public ScheduleNotFoundException(CommonErrorCode errorCode) {
        super(errorCode);
    }
}
