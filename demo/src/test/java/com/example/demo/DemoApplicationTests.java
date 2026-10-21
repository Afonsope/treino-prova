package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Pede ao Spring Boot que inicie o contexto completo durante o teste.
@SpringBootTest
class DemoApplicationTests {

	// Teste de fumaça: passar significa que o contexto conseguiu ser inicializado.
	// Ainda não valida diretamente os endpoints nem as operações de banco.
	@Test
	void contextLoads() {
	}

}
