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
@AllArgsConstructor
public class drp_mq_log implements Serializable{
    private String CODE;
    private String INT_TYPE;
    private String MARK;
    private String YYYYMMDD;
    private String PK_LIST;
    private String INFO;
    private String PRO_NAME;
    private String SYS_TYPE;
}
