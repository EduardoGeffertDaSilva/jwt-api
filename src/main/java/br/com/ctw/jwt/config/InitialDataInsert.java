package br.com.ctw.jwt.config;
import br.com.ctw.jwt.entity.Role;
import br.com.ctw.jwt.entity.User;
import br.com.ctw.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InitialDataInsert implements CommandLineRunner {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String ... args)throws Exception{

        if(repository.count() < 4){
            List<User> initialUsers = List.of(
                    User.builder()
                            .username("Eduardo")
                            .password(passwordEncoder.encode("1234"))
                            .role(Role.ADMIN)
                            .build(),
                    User.builder()
                            .username("Gui")
                            .password(passwordEncoder.encode("12345"))
                            .role(Role.USER)
                            .build()
            );

            repository.saveAll(initialUsers);
        }
    }
}
