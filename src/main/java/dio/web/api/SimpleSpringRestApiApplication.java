package dio.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SimpleSpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringRestApiApplication.class, args);
	}

}
