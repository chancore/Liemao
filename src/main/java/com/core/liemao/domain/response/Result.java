package com.core.liemao.domain.response;

import java.util.Map;

/**
 * 
 * @author chancore
 *
 */
public class Result {

    protected Integer status;
    protected String message;
    protected Map<String, Object> extendedProperties;
    protected String callback;
    protected String messageToUser;

    public Result() {
        this(0, "请求成功");
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public Map<String, Object> getExtendedProperties() {
        return extendedProperties;
    }

    public void setExtendedProperties(Map extendedProperties) {
        this.extendedProperties = extendedProperties;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
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

	/**
	 * @return the messageToUser
	 */
	public String getMessageToUser() {
		return messageToUser;
	}

	/**
	 * @param messageToUser the messageToUser to set
	 */
	public void setMessageToUser(String messageToUser) {
		this.messageToUser = messageToUser;
	}
	

}




