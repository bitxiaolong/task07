package com.encryption;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    //声明一个密钥，密钥保存在服务器端
    private final String SECRET = "wochitudou";

    //生成token
    public String createToken(String account)throws UnsupportedEncodingException {
        //签发时间
        Date signDate = new Date();
        //签发过期时间，设置为3分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,3);
        Date expiresDate = nowTime.getTime();
        //头部
        Map<String,Object> map = new HashMap<>();
        map.put("typ","JWT");
        map.put("alg","HS256");

        return JWT.create().withHeader(map)//头部
                .withClaim("account",account)//有效载体
                .withExpiresAt(expiresDate)//设置过期时间，过期时间要大于签发时间
                .withIssuedAt(signDate)//设置签发时间
                .sign(Algorithm.HMAC256(SECRET));
    }

    //解析token
    public DecodedJWT parserJavaWebToken(String token)throws UnsupportedEncodingException{

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        return verifier.verify(token);
    }

    public long tool(String token){
        String id = token.substring(0,token.indexOf("/"));
        return Long.parseLong(id);
    }

    public long tools(String token){
        String account = token.substring(token.indexOf("/"),1);
        return Long.parseLong(account);
    }
}
