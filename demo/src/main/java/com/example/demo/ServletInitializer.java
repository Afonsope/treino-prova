package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Permite executar a aplicação como WAR em um servidor Servlet externo, além do modo Spring Boot.
public class ServletInitializer extends SpringBootServletInitializer {

	// Informa ao servidor externo qual classe contém a configuração principal da aplicação.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

}
