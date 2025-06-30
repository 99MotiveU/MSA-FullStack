package com.sts.sts39.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class JwtService {
    // String accessKey = "발급받은 Access key";
    String secretKey = "12345678901234567890123456789012";

    public String create(String id){

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String jwtToken = JWT.create()
                //  .withClaim("access_key", accessKey)
                .withSubject("문서제목")
                .withClaim("id", id)
                .withClaim("msg", "abcd")
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60))
                // .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);
        return jwtToken;
        //String authenticationToken = "Bearer " + jwtToken;
    }

    public String Verify(String token){
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();

            decodedJWT = verifier.verify(token);
            String payload = decodedJWT.getClaims().get("id").asString();
            String msg = decodedJWT.getClaims().get("msg").asString();
            // boolean ok=decodedJWT.getExpiresAt().before(new Date());
            return payload+msg;
        } catch (JWTVerificationException exception){
            throw new RuntimeException("잘못된 토큰");
        }
    }
}
