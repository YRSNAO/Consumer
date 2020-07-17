package com.yrs.service;

import com.yrs.model.drp_mq_log;

public interface drp_mq_logservice {
    //MQ所接收的消息，均写到日志档
    public int insertlog(drp_mq_log drp_mq_log);
}
