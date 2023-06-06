package servers.api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;



public class Session {
    public String getSession(String username, String secretKey) {
        String secret = "jwtSalt";

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Date date = new Date();

        String jwtString = Jwts.builder()
                .claim("username", username)
                .setIssuedAt(date)
                .signWith(SignatureAlgorithm.HS512, hmacKey)
                .compact();

        return jwtString;
    }

    public String parseSession(){
        return "parsed";
    }
}
