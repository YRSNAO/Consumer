package com.yrs.mapper;

import com.yrs.model.drp_mq_log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface drp_mq_logmapper {
    //MQ所接收的消息，均写到日志档
    public int insertlog(drp_mq_log drp_mq_log);
}
