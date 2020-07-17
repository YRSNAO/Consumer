package com.yrs.service;

import com.alibaba.fastjson.JSONObject;
import com.yrs.model.drp_mq_log;
import com.yrs.service.impl.drp262t0serviceimpl;
import com.yrs.service.impl.drp_mq_logserviceimpl;
import com.yrs.until.dateuntil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YRS
 * @description rabbitmq服务类
 * @date 2020/7/8 0008
 */
@Slf4j
@Service
public class rabbitservice {
    @Resource
    private drp262t0serviceimpl drp262t0serviceimpl;
    @Resource
    private drp_mq_logserviceimpl drp_mq_logserviceimpl;

    @RabbitListener(queues = "mis_drptomis_dk_que")
    public void recive(String string) {
        String nowDate = dateuntil.getNowDate();
        if (string.isEmpty() != true && string.contains("BILL_ID")&&string.contains("remark")&&string.contains("reportno") && string.contains("state") && string.contains("{") && string.contains("}")) {
            JSONObject object = JSONObject.parseObject(string);
            String bill_id = object.getString("BILL_ID");
            String state = object.getString("state");
            String remark = object.getString("remark");
            String reportno = object.getString("reportno");
            Integer amt = object.getInteger("amt_ss");

            if (amt != null && amt >= 0) {
                log.info("*****金额不为0走改：状态、金额 逻辑*****" + bill_id + state + amt);
                int i = drp262t0serviceimpl.updateamt(bill_id, state, amt);
                if (i > 0) {
                    drp_mq_log drp_mq_log=new drp_mq_log();
                    drp_mq_log.setCODE("02");
                    drp_mq_log.setINT_TYPE("200001");
                    drp_mq_log.setMARK("01");
                    drp_mq_log.setYYYYMMDD(nowDate);
                    drp_mq_log.setPK_LIST(bill_id);
                    drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
                    drp_mq_log.setINFO(string);
                    drp_mq_log.setSYS_TYPE("MIS");
                    int insertlog = drp_mq_logserviceimpl.insertlog(drp_mq_log);
                    log.info("*****状态、金额修改完毕*****");
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                } else {
                    drp_mq_log drp_mq_log=new drp_mq_log();
                    log.info("*****状态、金额修改失败*****");
                    drp_mq_log.setCODE("02");
                    drp_mq_log.setINT_TYPE("200001");
                    drp_mq_log.setMARK("02");
                    drp_mq_log.setYYYYMMDD(nowDate);
                    drp_mq_log.setPK_LIST(bill_id);
                    drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
                    drp_mq_log.setINFO(string);
                    drp_mq_log.setSYS_TYPE("MIS");
                    int insertlog = drp_mq_logserviceimpl.insertlog(drp_mq_log);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                }
            } else {

                log.info("*****金额为0走改：状态 逻辑*****" + bill_id + state);
                int i = drp262t0serviceimpl.updatestate(bill_id, state,remark,reportno);
                if (i > 0) {
                    drp_mq_log drp_mq_log=new drp_mq_log();
                    log.info("*****状态修改完毕*****");
                    drp_mq_log.setCODE("02");
                    drp_mq_log.setINT_TYPE("200001");
                    drp_mq_log.setMARK("01");
                    drp_mq_log.setYYYYMMDD(nowDate);
                    drp_mq_log.setPK_LIST(bill_id);
                    drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
                    drp_mq_log.setINFO(string);
                    drp_mq_log.setSYS_TYPE("MIS");
                    int insertlog = drp_mq_logserviceimpl.insertlog(drp_mq_log);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                } else {
                    drp_mq_log drp_mq_log=new drp_mq_log();
                    log.info("*****状态修改失败*****");
                    drp_mq_log.setCODE("02");
                    drp_mq_log.setINT_TYPE("200001");
                    drp_mq_log.setMARK("02");
                    drp_mq_log.setYYYYMMDD(nowDate);
                    drp_mq_log.setPK_LIST(bill_id);
                    drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
                    drp_mq_log.setINFO(string);
                    drp_mq_log.setSYS_TYPE("MIS");
                    int insertlog = drp_mq_logserviceimpl.insertlog(drp_mq_log);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                }
            }
        } else {
            drp_mq_log drp_mq_log=new drp_mq_log();
            log.info("*****接收消息数据异常，不做业务处理,异常数据为：*****" + string);
            drp_mq_log.setCODE("02");
            drp_mq_log.setINT_TYPE("200001");
            drp_mq_log.setMARK("02");
            drp_mq_log.setYYYYMMDD(nowDate);
            drp_mq_log.setPK_LIST("没有获取到相关主键信息");
            drp_mq_log.setPRO_NAME("mis_drptomis_dk_que");
            drp_mq_log.setINFO(string);
            drp_mq_log.setSYS_TYPE("MIS");
            int insertlog = drp_mq_logserviceimpl.insertlog(drp_mq_log);
            if (insertlog > 0) {
                log.info("*****写入日志档成功*****");
            } else {
                log.info("*****写入日志档失败*****");
            }
        }
    }
}
