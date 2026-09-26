package br.com.ctw.jwt.dto.task;
import br.com.ctw.jwt.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDto (

        @NotBlank
        @NotNull
        @Size(
                min = 0,
                max = 30
        )
        String username,

        @NotNull
        @NotBlank
        @Size(
                min = 0,
                max = 30
        )
        String password,

        @NotNull
        Role role
){}
