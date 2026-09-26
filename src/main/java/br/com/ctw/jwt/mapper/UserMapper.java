package br.com.ctw.jwt.mapper;
import br.com.ctw.jwt.dto.task.TaskResponseDto;
import br.com.ctw.jwt.dto.task.UserRequestDto;
import br.com.ctw.jwt.dto.user.UserResponseDto;
import br.com.ctw.jwt.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder encoder;

    public User toEntity(UserRequestDto requestDto){
        return User.builder()
                .username(requestDto.username())
                .password(encoder.encode(requestDto.password()))
                .role(requestDto.role())
                .build();
    }

    public UserResponseDto toResponse(User user){

        List<TaskResponseDto> taskResponseDto = user.getTasks().stream().map((task -> {
            return new TaskResponseDto(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getCompleted(),
                    task.getUserId().getUsername()
            );
        })).toList();

        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                taskResponseDto
        );
    }

}
