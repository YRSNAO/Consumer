package com.yrs.until;

import com.yrs.model.drp_mq_log;

/**
 * 收消息的工具类
 * 1、判定是否存在主关键字bill_id\state\remark\reportno
 * 2、判定是否存在主关键字bill_id\state\remark\amt_ss
 * 3、如果不存在以上关键字，则视为异常数据
 */
public class messageuntil {
    public drp_mq_log getmessagetrue(String string, String bill_id) {
        String nowDate = dateuntil.getNowDate();
        drp_mq_log drp_mq_log = new drp_mq_log();
        drp_mq_log.setCODE("02");
        drp_mq_log.setINT_TYPE("200001");
        drp_mq_log.setMARK("01");
        drp_mq_log.setYYYYMMDD(nowDate);
        drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
        drp_mq_log.setSYS_TYPE("MIS");
        drp_mq_log.setPK_LIST(bill_id);
        drp_mq_log.setINFO(string);
        return drp_mq_log;
    }

    public drp_mq_log getmessagefalse(String string, String bill_id) {
        String nowDate = dateuntil.getNowDate();
        drp_mq_log drp_mq_log = new drp_mq_log();
        drp_mq_log.setCODE("02");
        drp_mq_log.setINT_TYPE("200001");
        drp_mq_log.setMARK("02");
        drp_mq_log.setYYYYMMDD(nowDate);
        drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
        drp_mq_log.setSYS_TYPE("MIS");
        drp_mq_log.setPK_LIST(bill_id);
        drp_mq_log.setINFO(string);
        return drp_mq_log;
    }
}
