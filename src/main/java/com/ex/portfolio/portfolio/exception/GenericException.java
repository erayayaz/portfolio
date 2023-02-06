package com.ex.portfolio.portfolio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private String errorMessage;
}
