package br.com.ctw.jwt.dto.auth;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRequestDto (

        @NotNull
        @NotBlank
        String username,

        @NotNull
        @NotBlank
        String password
){}
