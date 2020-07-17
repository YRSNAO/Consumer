package com.yrs.service.impl;

import com.yrs.mapper.drp_mq_logmapper;
import com.yrs.model.drp_mq_log;
import com.yrs.service.drp_mq_logservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class drp_mq_logserviceimpl implements drp_mq_logservice {
    @Resource
    private drp_mq_logmapper drp_mq_logmapper;

    @Override
    public int insertlog(drp_mq_log drp_mq_log) {
        int i = drp_mq_logmapper.insertlog(drp_mq_log);
        if (i > 0) {
            return i;
        } else {
            return 0;
        }

    }
}
