package com.yrs.comment;

/**
 * 测试
 */

public enum resultcode {
    SUCCESS(true, 200, "成功！"),
    FAIL(false, 444, "失败");
    boolean success;
    int code;
    String message;

    resultcode(boolean success, int code, String message){
        this.success=success;
        this.code=code;
        this.message=message;
    }

}
