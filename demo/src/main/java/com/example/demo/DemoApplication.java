package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marca esta classe como ponto de entrada do Spring Boot e habilita a configuração automática.
// A busca por componentes (como controllers e services) começa neste pacote e em seus subpacotes.
@SpringBootApplication
public class DemoApplication {

	// O Java inicia a aplicação por este método.
	public static void main(String[] args) {
		// Inicializa o contexto do Spring, configura os componentes e inicia o servidor web embutido.
		SpringApplication.run(DemoApplication.class, args);
	}

}
