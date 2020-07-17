package com.yrs.until;

import com.yrs.comment.resultcode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author YRS
 * @description 返回结果集
 * @date 2020/7/5 0005
 */
@Data
@Setter
@Getter
public class result<T>{
    private boolean success;
    private int code;
    private String message;

    public result(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }


}
