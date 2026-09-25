package br.com.ctw.jwt.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(
                new Info()
                        .title("Api para aprendizado de Spring Security")
                        .description("Api para aplicar conhecimentos adquiridos nas aulas de Back-End, sendo eles ApiRest, OpenAPI, Swagger, Jpa, Spring Security")
                        .version("0.1")
                        .contact(new Contact()
                                .email("gefferteduardo@gmail.com")
                                .name("Eduardo Geffert da Silva")
                        )
        );
    }

}
