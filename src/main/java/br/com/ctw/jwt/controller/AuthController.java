package br.com.ctw.jwt.controller;
import br.com.ctw.jwt.dto.auth.AuthenticationRequestDto;
import br.com.ctw.jwt.dto.auth.AuthenticationResponseDto;
import br.com.ctw.jwt.entity.User;
import br.com.ctw.jwt.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    private ResponseEntity<AuthenticationResponseDto> fazerAutenticacao(@RequestBody @Valid AuthenticationRequestDto requestDto){

        var authToken = new UsernamePasswordAuthenticationToken(requestDto.username(), requestDto.password());

        var auth = authenticationManager.authenticate(authToken);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new AuthenticationResponseDto(token));
    }

}
