package com.core.liemao.domain.exception;

/**
 * 
 * @author chancore
 *
 */
public class ErrorInfo {

    private Integer status;
    private String message;
    private String messageToUser;

    public ErrorInfo() {
    }

    public ErrorInfo(Integer status, String message, String messageToUser) {
        this.status = status;
        this.message = message;
        this.messageToUser = messageToUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageToUser() {
        return messageToUser;
    }

    public void setMessageToUser(String messageToUser) {
        this.messageToUser = messageToUser;
    }
}
