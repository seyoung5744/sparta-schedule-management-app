package com.example.spartaschedulemanagement.exception;

import com.example.spartaschedulemanagement.exception.common.CommonErrorCode;
import com.example.spartaschedulemanagement.exception.common.GlobalException;

public class InvalidPasswordException extends GlobalException {

    public InvalidPasswordException(CommonErrorCode errorCode) {
        super(errorCode);
    }
}
