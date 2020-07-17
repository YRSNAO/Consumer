package com.yrs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface drp262t0mapper {
    //通过bill_id修改单据状态
    public int updatestate(@Param("bill_id") String bill_id, @Param("state") String state,@Param("remark") String remark,@Param("reportno") String reportno);

    //通过bill_id修改单据状态和金额
    public int updateamt(@Param("bill_id") String bill_id, @Param("state") String state,@Param("remark") String remark, @Param("amt") Integer amt);
}
