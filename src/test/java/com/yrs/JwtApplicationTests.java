package com.yrs;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
        /* String key = "yrs";
         int exp=3600;
        JwtBuilder jwtBuilder = Jwts.builder().setId("18080123").setSubject("意如霜").claim("api", "www.baidu.com").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "yrss");
        jwtBuilder.setExpiration(new Date(exp));
        String token = jwtBuilder.compact();
        System.out.println(token);*/
        String message = "{\"BILL_ID\":\"4044XW202007160002\",\"remark\":\"已抛转接口-5653808-20200716105748\",\"state\":\"30\",\"reportno\":\"44002020071611000001\"}";
        JSONObject object = JSONObject.parseObject(message);
        String bill_id = object.getString("BILL_ID");
        System.out.println(bill_id);
    }
}
