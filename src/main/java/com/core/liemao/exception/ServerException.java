package com.core.liemao.exception;
/** 
 * @author 作者 : chenxuan
 * @version 创建时间：2015年10月21日 下午1:48:16 
 * 类说明 
 */
public class ServerException extends RuntimeException{

	private static final long serialVersionUID = -7340698584501940973L;
	protected Integer status;
	
    public ServerException() {
    }
    
    public ServerException(Integer status,String message) {
        super(message);
        this.status = status;
    }
    
    public ServerException(Integer status,String message, Throwable cause) {

        super(message, cause);
        this.status = status;
    }

    public ServerException(Throwable cause) {

        super(cause);
    }

    public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public Integer getStatus() {
		return status;
	}
    
    public void setStatus(Integer status) {
		this.status = status;
	}
}
