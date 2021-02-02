package com.senecaglobal.myshop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @description: List of exceptions to be thrown
 * @author: Suresh_Vannale
 */
@Getter
@AllArgsConstructor
public class RestBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}