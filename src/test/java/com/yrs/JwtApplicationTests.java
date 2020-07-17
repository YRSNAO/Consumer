package com.yrs;

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
         String key = "yrs";
         int exp=3600;
        JwtBuilder jwtBuilder = Jwts.builder().setId("18080123").setSubject("意如霜").claim("api", "www.baidu.com").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "yrss");
        jwtBuilder.setExpiration(new Date(exp));
        String token = jwtBuilder.compact();
        System.out.println(token);
    }
}
