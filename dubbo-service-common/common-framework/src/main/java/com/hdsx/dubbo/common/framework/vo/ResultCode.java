package com.hdsx.dubbo.common.framework.vo;

/**
 * 具体的消息码和消息
 */
public enum ResultCode {
    /** 公共部分*/
    ADD_KEY_REPEATS(0,"信息重复（名称重复）"),
    PARAMETER_ERROR(0, "参数错误"),
    PARAMETER_NOT_EXIST(0, "参数不能为空"),
    NAME_EXIT(0, "名称存在"),
    SYSTEM_UNKNOW_EXCEPTION(0, "系统异常, 请稍后再试"),

    QUERY_FAIL(0, "查询失败"),
    QUERY_SUCCESS(1, "查询成功"),
    QUERY_NO_DATA(0, "未查询到数据"),

    ADD_SUCCESS(1, "新增信息成功"),
    ADD_FAIL(0,"新增信息失败"),
    UPDATE_SUCCESS(1, "成功更新信息"),
    UPDATE_FAIL(0, "更新信息失败"),
    DELETE_SUCCESS(1, "删除成功"),
    DELETE_FAIL(0, "删除失败"),

    PASSWORD_EMPTY(0, "密码为空"),
    AUTH_UNKNOWN(0, "注销失败"),
    AUTH_SUCCESS(1, "注销成功"),
    LOGIN_SUCCESS(1, "登录成功"),
    LOGIN_FAIL(0, "登录失败"),
    AUTH_PARAMETER_ERROR(0, "用户名或密码为空"),
    USER_FORBIDDEN(0, "用户不可用"),
    PASSWORD_ERROR(0, "密码错误"),
    MODIFY_SUCCESS(1,"修改成功"),
    MODIFY_FAIL(0,"修改失败"),
    PARAMETER_EXISTING(0, "参数已经存在"),
    MESSAGE_CODE_ERROR(0, "短信验证码不正确"),
    MESSAGE_USERNAME_PHONE_NOT_BLANK(0,"用户名和手机号不能为空"),
    MESSAGE_PHONE_ERROR(0,"该用户未绑定手机号，请联系管理员绑定"),
    MESSAGE_USERNAME_PHONE_ERROR(0,"用户名与手机号不匹配"),
    MESSAGE_HAS_MONTHLY_REPORT_ERROR(0,"添加失败，该月报时间的进展已填报，不能重复添加"),

    USERNAME_PASSWORD_ENABLE(0, "密码连续出现五次错误，已锁定账号，请联系管理员启用账号");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
