package com.yrs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.CLOB;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.sql.Clob;

@Data
@NoArgsConstructor
public class drp_mq_log implements Serializable{
    private String CODE;
    private String INT_TYPE;
    private String MARK;
    private String YYYYMMDD;
    private String PK_LIST;
    private String INFO;
    private String PRO_NAME;
    private String SYS_TYPE;
    public drp_mq_log(String CODE, String INT_TYPE, String MARK, String YYYYMMDD, String PK_LIST, String INFO, String PRO_NAME, String SYS_TYPE) {
        this.CODE = CODE;
        this.INT_TYPE = INT_TYPE;
        this.MARK = MARK;
        this.YYYYMMDD = YYYYMMDD;
        this.PK_LIST = PK_LIST;
        this.INFO = INFO;
        this.PRO_NAME = PRO_NAME;
        this.SYS_TYPE = SYS_TYPE;
    }
}
