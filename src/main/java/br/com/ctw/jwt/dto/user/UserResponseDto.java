package br.com.ctw.jwt.dto.user;
import br.com.ctw.jwt.dto.task.TaskResponseDto;
import br.com.ctw.jwt.entity.Role;
import java.util.List;

public record UserResponseDto (

        Long id,
        String username,
        Role role,
        List<TaskResponseDto> tasks
){}
