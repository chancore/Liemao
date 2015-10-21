package com.core.liemao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.core.liemao.domain.exception.ErrorConstant;
import com.core.liemao.domain.exception.ErrorInfo;

/**
 * @author chancore
 */
@ResponseStatus(value = HttpStatus.OK)
@ControllerAdvice(basePackages = "com.core.liemao.controller")
public class BasicExceptionHandler {
    public Logger logger = LoggerFactory.getLogger(getClass());

    
    @ExceptionHandler(value = {DataAccessException.class})
    @ResponseBody
    public ErrorInfo handleDBError(DataAccessException ex) {
        String errorMessage = ex.getMessage();
        logger.error(ex.getMessage(), ex);
        return new ErrorInfo(ErrorConstant.DB_ERROR.getErrorCode(), errorMessage,
            ErrorConstant.DB_ERROR.getErrorMessageToUser());
    }
    
    @ExceptionHandler(ServerException.class)
    @ResponseBody
    public ErrorInfo handleServerException(ServerException ex) {
        Integer errorCode = ex.getStatus();
        String internalErrorMsg = ex.getMessage();
        String errorMsg = ErrorConstant.REQUEST_FAIL_ERROR.getErrorMessageToUser();
        logger.error(ex.getMessage(), ex);
        return new ErrorInfo(errorCode,errorMsg,internalErrorMsg);
    }
}