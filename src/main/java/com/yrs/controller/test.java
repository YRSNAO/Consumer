/*
package com.yrs.controller;

import com.yrs.service.impl.drp262t0serviceimpl;
import com.yrs.until.jwtuntil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

*/
/**
 * @author YRS
 * @description test的controller
 * @date 2020/7/8 0008
 *//*

@Slf4j
@RestController
public class test {
    @Autowired
    private drp262t0serviceimpl drp262t0serviceimpl;
    @RequestMapping("/test")
    public String gettoken(HttpServletRequest request) {
        */
/*String authorization = request.getHeader("Authorization");
        String token = authorization.replace("Bearer ", "");
        jwtuntil jwtuntil = new jwtuntil();
        String istoken = jwtuntil.istoken(token);
        if (istoken.isEmpty() != true) {
            System.out.println(istoken);
            return "认证成功";
        } else {
            return "认证失败";
        }
*//*

        int updatestate = drp262t0serviceimpl.updatestate("", "");
        if (updatestate>0){
            log.info("修改成功");
            return "修改成功";
        }else {
            log.info("修改失败");
            return "修改失败";
        }
    }
}
*/
