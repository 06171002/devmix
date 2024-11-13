package msa.devmix;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(info = @Info(title = "My API", version = "3.1.0", description = "My API Description"))
@EnableJpaAuditing
@SpringBootApplication
public class DevmixApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevmixApplication.class, args);
	}

}
