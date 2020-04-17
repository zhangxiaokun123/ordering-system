package com.ly.orderingsystem.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
/通用返回值实例
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResult {
    //响应状态码
    private int code;
    //响应状态消息
    private String msg;
    //响应结果对象
    private Object object;
}
