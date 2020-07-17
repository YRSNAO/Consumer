package com.yrs.until;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YRS
 * @description jwt工具类
 * @date 2020/7/5 0005
 */

public class jwtuntil {
    public String createjwt() {
        Map map = new HashMap();
        map.put("userid", "18080123");
        map.put("username", "意如霜");
        JwtBuilder jwtBuilder = Jwts.builder().setId("18080123").setSubject("意如霜").setClaims(map).signWith(SignatureAlgorithm.HS256, "hfqy");
        String token = jwtBuilder.compact();
        return token;
    }
    public String istoken(String string) {
        Claims claims = Jwts.parser().setSigningKey("hfqy").parseClaimsJws(string).getBody();
        if (claims.isEmpty() != true) {
            String id = claims.getId();
            String subject = claims.getSubject();
            String userid = (String) claims.get("userid");
            String username = (String) claims.get("username");
            return "token认证成功" + "id:" + id + "subject:" + subject + "userid:" + userid + "username:" + username;
        } else {
            return "token认证失败";
        }

    }
}
