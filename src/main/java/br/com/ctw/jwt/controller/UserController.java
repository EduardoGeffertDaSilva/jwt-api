package br.com.ctw.jwt.controller;
import br.com.ctw.jwt.dto.task.UserRequestDto;
import br.com.ctw.jwt.dto.user.UserResponseDto;
import br.com.ctw.jwt.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/cadastro")
    private ResponseEntity<UserResponseDto> cadastrarUsuario(@RequestBody @Valid UserRequestDto requestDto){
        return ResponseEntity.ok(service.cadastrarUsuarios(requestDto));
    }

}
