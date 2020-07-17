package com.yrs.until;

import com.yrs.model.drp_mq_log;

/**
 * drp_mq_log生成工具类
 * 1、无异常时使用getmessagetrue生成
 * 2、有异常时使用getmessagefalse生成
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
