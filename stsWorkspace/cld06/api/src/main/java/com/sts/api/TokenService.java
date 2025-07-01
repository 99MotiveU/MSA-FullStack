package com.sts.api;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
    
    String keymsg="12345678901234567890123456789012";
	Key key=Keys.hmacShaKeyFor(keymsg.getBytes());
	
	public String jwtCreate(String username) {
//		SecretKey key = Jwts.SIG.HS256.key().build();
		String jwt = Jwts.builder()                     // (1)
			    .header()                                   // (2) optional
			        .keyId("aKeyId")
			        .and()
			    .subject(username)                             // (3) JSON Claims, or
			    //.content(aByteArray, "text/plain")        //     any byte[] content, with media type
			    .signWith(key)                       // (4) if signing, or
			    //.encryptWith(key, keyAlg, encryptionAlg)  //     if encrypting
			    .compact();                                 // (5)
		return jwt;
	}
}
