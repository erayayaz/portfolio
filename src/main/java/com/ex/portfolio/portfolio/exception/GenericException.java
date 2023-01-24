package com.ex.portfolio.portfolio.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
}
