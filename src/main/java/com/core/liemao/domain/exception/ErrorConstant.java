package com.core.liemao.domain.exception;

/**
 * Created by henryhome on 2/21/15.
 */
public class ErrorConstant {

    private Integer errorCode;
    private String errorMessageToUser;
    private String msg;
    
    public ErrorConstant(Integer errorCode, String errorMessageToUser) {
        this.errorCode = errorCode;
        this.errorMessageToUser = errorMessageToUser;
    }

    public ErrorConstant(Integer errorCode, String errorMessageToUser,
			String msg) {
		super();
		this.errorCode = errorCode;
		this.errorMessageToUser = errorMessageToUser;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageToUser() {
        return errorMessageToUser;
    }

    public void setErrorMessageToUser(String errorMessageToUser) {
        this.errorMessageToUser = errorMessageToUser;
    }
    
    public static final ErrorConstant SUCCESS = new ErrorConstant(0, "请求成功");
    public static final ErrorConstant BAD_REQUEST = new ErrorConstant(400, "请求参数有问题");
    public static final ErrorConstant UNAUTHORIZED = new ErrorConstant(401, "认证没有通过");
    public static final ErrorConstant SERVER_ERROR = new ErrorConstant(500, "服务器错误");
    public static final ErrorConstant DB_ERROR = new ErrorConstant(667, "数据库错误");
    public static final ErrorConstant SERVER_BUSY = new ErrorConstant(555, "服务器繁忙");
    public static final ErrorConstant PARAM_ERROR = new ErrorConstant(666, "参数错误");
    public static final ErrorConstant REQUEST_FAIL_ERROR = new ErrorConstant(668, "请求失败");
    public static final ErrorConstant PHONE_NUMBER_NOT_NULL = new ErrorConstant(100001, "手机号码不能为空");
    public static final ErrorConstant PHONE_NUMBER_FORMAT_ERROR = new ErrorConstant(100002, "手机号码格式错误");
    public static final ErrorConstant VERIFICATION_CODE_FORMAT_ERROR = new ErrorConstant(100003, "验证码不能为空");
    public static final ErrorConstant VERIFICATION_CODE_ERROR = new ErrorConstant(100004, "验证码错误");
    public static final ErrorConstant USER_ALREADY_EXISTS = new ErrorConstant(100005, "用户已经存在");
    public static final ErrorConstant WEIXIN_USER_ALREADY_EXISTS = new ErrorConstant(100006, "该微信用户已经存在");
    public static final ErrorConstant WEIXINID_NUMBER_NOT_NULL = new ErrorConstant(100007, "微信ID不能为空");
    public static final ErrorConstant FRONT_IMG_NOT_NULL = new ErrorConstant(100008, "请上传正面图片");
    public static final ErrorConstant BACK_IMG_NOT_NULL = new ErrorConstant(100009, "请上传反面图片");
    public static final ErrorConstant USER_ID_NOT_NULL = new ErrorConstant(100010, "用户ID不能为空");
    public static final ErrorConstant FILE_SAVE_FAIL = new ErrorConstant(100011, "图片保存失败");
    public static final ErrorConstant PARENT_ID_NOT_NULL = new ErrorConstant(100012, "parentId不能为空");
    public static final ErrorConstant TYPE_NOT_NULL = new ErrorConstant(100013, "type不能为空");
 
    
}