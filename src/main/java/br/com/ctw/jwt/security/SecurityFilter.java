package br.com.ctw.jwt.security;
import br.com.ctw.jwt.repository.UserRepository;
import br.com.ctw.jwt.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService service;
    private final UserRepository repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);

        if (token != null) {
            String subject = service.validarToken(token);

            if(subject != null){
                var user = repository.findUserByUsername(subject);

                if (user != null){
                    var authentication = new UsernamePasswordAuthenticationToken(
                            user,null,user.get().getAuthorities()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request,response);
    }

    private String recuperarToken(HttpServletRequest request){

        String header = request.getHeader("Authorization");

        if(header == null || header.startsWith("Bearer ")){
            return null;
        }

        return header.substring(7);
    }

}
