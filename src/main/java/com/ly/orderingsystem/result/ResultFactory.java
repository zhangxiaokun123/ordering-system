package com.ly.orderingsystem.result;

/**
 * @description 响应结果生成工厂类
 */
public class ResultFactory {
    public static AjaxResult buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static AjaxResult buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static AjaxResult buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static AjaxResult buildResult(int resultCode, String message, Object data) {
        return new AjaxResult(resultCode, message, data);
    }
}
