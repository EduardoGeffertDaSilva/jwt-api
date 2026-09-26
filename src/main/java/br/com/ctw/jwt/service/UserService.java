package br.com.ctw.jwt.service;
import br.com.ctw.jwt.dto.task.UserRequestDto;
import br.com.ctw.jwt.dto.user.UserResponseDto;
import br.com.ctw.jwt.mapper.UserMapper;
import br.com.ctw.jwt.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Erro ao buscar username " + username));
    }

    @Transactional
    public UserResponseDto cadastrarUsuarios(UserRequestDto requestDto){
        return mapper.toResponse(repository.save(mapper.toEntity(requestDto)));
    }
}
