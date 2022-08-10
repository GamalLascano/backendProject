package com.gamal.signup.util;

import com.gamal.signup.model.UserEntity;
import com.gamal.signup.model.UserException;
import com.gamal.signup.repository.UserRepository;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class TokenHelper {
    @Value("${secret.key}")
    private String secretKey;
    @Autowired
    private UserRepository repository;

    public String generateToken(UserEntity user){
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(user.getEmail()).setIssuedAt(Date.from(Instant.now()))
                .signWith(SignatureAlgorithm.HS512,secretKey).compact();
    }
    public Optional<UserEntity> validateUser(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
            return repository.findByEmail(claims.getSubject());
        }catch(MalformedJwtException e){
            throw new UserException(HttpStatus.BAD_REQUEST,"JWT Token does not have a correct format");
        }catch(UnsupportedJwtException e){
            throw new UserException(HttpStatus.BAD_REQUEST,"Using the requested JWT token is not supported");
        }catch(Exception e){
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong with the jwt token");
        }

    }
}
