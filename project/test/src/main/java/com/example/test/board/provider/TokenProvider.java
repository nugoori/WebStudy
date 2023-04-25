package com.example.test.board.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;      

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenProvider {
    
    @Value("${jwt.security-key}")
    private String SECURITY_KEY;

    // JWT 생성하는 매서드
    public String create (String email) {
        // 만료날짜를 현재 날짜 + 1시간으로 설정
        Date expiredTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        // JWT를 생성해주는 함수
        String jwt = Jwts.builder()
                        // 암호화에 사용될 알고리즘, 키
                        .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                        // JWT의 제목, 생성일, 만료일
                        .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredTime)
                        // 생성
                        .compact();
                    
                    return jwt;
    }

    public String vaildate (String jwt) {
        // 매개변수로 받은 token을 키로 사용하여 복호화 (= 디코딩)
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(jwt).getBody();

        // 복호화된 토큰의 payload에서 제목을 가져옴
        // parsing한 claims안에 있는 subject값 
        // = create의 return 부분의 .setSubject(userEmail)을 가져올 수 있음
        return claims.getSubject();
    }
}
