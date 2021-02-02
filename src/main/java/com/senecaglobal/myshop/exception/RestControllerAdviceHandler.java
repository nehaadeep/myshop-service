package com.senecaglobal.myshop.exception;

import com.senecaglobal.myshop.models.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @description: Handle all global exceptions here
 * @author: Suresh_Vannale
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerAdviceHandler {

    @Autowired
    private ErrorResponseHelper errorResponseHelper;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAdviceHandler.class);

    /**
     * Custom exception
     *
     * @param restBaseException of type {@link RestBaseException}
     * @return ResponseEntity
     */
    @ExceptionHandler(value = {RestBaseException.class})
    public ResponseEntity<ErrorResponse> customException(RestBaseException restBaseException) {
        LOGGER.error("Custom error thrown", restBaseException);
        ErrorResponse errorResponse = errorResponseHelper.mapErrorResponse(restBaseException.getCode(), restBaseException.getMessage());
        return new ResponseEntity<>(errorResponse, restBaseException.getHttpStatus());
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResponseEntity<ErrorResponse> badRequest(NoHandlerFoundException exception) {
        LOGGER.error("No handler found for {}", exception.getRequestURL());
        ErrorResponse errorResponse = errorResponseHelper.mapErrorResponse(ErrorCode.BAD_REQUEST.getErrorCode(), ErrorMessage.NO_HANDLER_FOUND_ERROR.getErrorMsg());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Common exception handling for all kind of exceptions
     *
     * @param exception of type {@link Exception}
     * @return ResponseEntity
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponse> commonException(Exception exception) {
        LOGGER.error("Unhandled exception occurred", exception);
        ErrorResponse errorResponse = errorResponseHelper.mapErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR.getErrorCode(), ErrorMessage.UN_HANDLED_ERROR.getErrorMsg());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}