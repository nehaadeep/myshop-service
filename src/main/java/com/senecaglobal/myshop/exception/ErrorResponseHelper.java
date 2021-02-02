package com.senecaglobal.myshop.exception;

import com.senecaglobal.myshop.models.ErrorResponse;
import org.springframework.stereotype.Component;

/**
 * @description: Helper class for handling error codes
 * @author: Suresh_Vannale
 */
@Component
public class ErrorResponseHelper {
    /**
     * Map error code, statusCode and message to {@link com.senecaglobal.myshop.models.ErrorResponse}
     *
     * @param errorCode    of type String
     * @param errorMessage of type String
     * @return ErrorResponse
     */
    public ErrorResponse mapErrorResponse(String errorCode, String errorMessage) {
        return new ErrorResponse().code(errorCode).message(errorMessage);
    }
}
