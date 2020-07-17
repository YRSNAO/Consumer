package com.yrs.service;

import com.alibaba.fastjson.JSONObject;
import com.yrs.model.drp_mq_log;
import com.yrs.service.impl.drp262t0serviceimpl;
import com.yrs.service.impl.drp_mq_logserviceimpl;
import com.yrs.until.messageuntil;
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
        if (string.isEmpty() != true && string.contains("bill_id") && string.contains("remark") && string.contains("reportno") && string.contains("state") && string.contains("{") && string.contains("}")) {
            JSONObject object = JSONObject.parseObject(string);
            String bill_id = object.getString("bill_id");
            String state = object.getString("state");
            String remark = object.getString("remark");
            String reportno = object.getString("reportno");
            Integer amt = object.getInteger("amt_ss");
            if (amt != null && amt >= 0) {
                log.info("*****金额不为0走改：状态、金额 逻辑*****" + bill_id + state + amt);
                int i = drp262t0serviceimpl.updateamt(bill_id, state, remark, amt);
                if (i > 0) {
                    log.info("*****状态、金额修改完毕*****");
                    drp_mq_log getmessagetrue = new messageuntil().getmessagetrue(string, bill_id);
                    int insertlog = drp_mq_logserviceimpl.insertlog(getmessagetrue);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                } else {
                    log.info("*****状态、金额修改失败*****");
                    drp_mq_log getmessagefalse = new messageuntil().getmessagefalse(string, bill_id);
                    int insertlog = drp_mq_logserviceimpl.insertlog(getmessagefalse);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                }
            } else {
                log.info("*****金额为0走改：状态 逻辑*****" + bill_id + state);
                int i = drp262t0serviceimpl.updatestate(bill_id, state, remark, reportno);
                if (i > 0) {
                    log.info("*****状态修改完毕*****");
                    drp_mq_log getmessagetrue = new messageuntil().getmessagetrue(string, bill_id);
                    int insertlog = drp_mq_logserviceimpl.insertlog(getmessagetrue);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                } else {
                    log.info("*****状态修改失败*****");
                    drp_mq_log getmessagefalse = new messageuntil().getmessagefalse(string, bill_id);
                    int insertlog = drp_mq_logserviceimpl.insertlog(getmessagefalse);
                    if (insertlog > 0) {
                        log.info("*****写入日志档成功*****");
                    } else {
                        log.info("*****写入日志档失败*****");
                    }
                }
            }
        } else {
            log.info("*****接收消息数据异常，不做业务处理,异常数据为：*****" + string);
            drp_mq_log getmessagefalse = new messageuntil().getmessagefalse(string, "参数不正确");
            int insertlog = drp_mq_logserviceimpl.insertlog(getmessagefalse);
            if (insertlog > 0) {
                log.info("*****写入日志档成功*****");
            } else {
                log.info("*****写入日志档失败*****");
            }
        }
    }
}
