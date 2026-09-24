package br.com.ctw.jwt.service;
import br.com.ctw.jwt.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import static com.auth0.jwt.RegisteredClaims.ISSUER;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secretToken;

    public String generateToken(User user){

        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getPassword())
                    .withExpiresAt(definirData())
                    .sign(Algorithm.HMAC256(secretToken));
        }catch (JWTVerificationException e){
            throw new JWTVerificationException("Erro ao gerar token");
        }
    }

    public String validarToken(String token){

        try {
            return JWT.require(Algorithm.HMAC256(token))
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new JWTVerificationException("Token Invalidado " + token);
        }
    }

    public Instant definirData(){

        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

    }
}
