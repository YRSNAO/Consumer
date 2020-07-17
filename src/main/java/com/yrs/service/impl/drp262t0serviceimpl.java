package com.yrs.service.impl;

import com.yrs.mapper.drp262t0mapper;
import com.yrs.service.drp262t0service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class drp262t0serviceimpl implements drp262t0service {
    @Resource
    private drp262t0mapper drp262t0mapper;

    @Override
    public int updatestate(String bill_id,String state,String remark,String reportno) {
        int i = drp262t0mapper.updatestate(bill_id,state,remark,reportno);
        if (i > 0) {
            return i;
        } else {
            return 0;
        }

    }

    @Override
    public int updateamt(String bill_id,String state,String remark,Integer amt) {
        int i = drp262t0mapper.updateamt(bill_id,state,remark,amt);
        if (i > 0) {
            return i;
        } else {
            return 0;
        }
    }
}
