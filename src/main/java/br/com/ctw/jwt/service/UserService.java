package br.com.ctw.jwt.service;
import br.com.ctw.jwt.entity.User;
import br.com.ctw.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Erro ao buscar username " + username));
    }
}
