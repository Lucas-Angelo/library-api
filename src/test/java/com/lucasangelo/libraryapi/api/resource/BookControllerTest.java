package com.lucasangelo.libraryapi.api.resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// Serão feitos testes unitários aqui
// Configuração para criar um mini contexto para rodar o teste
@ExtendWith(SpringExtension.class) // O Controller do SpringBoot é feito assim
@ActiveProfiles("test") // Para algumas coisas rodar apenas nesses perfis marcos como "test"
@WebMvcTest
@AutoConfigureMockMvc // Spring faz uma configuração de um objeto para as requisições
public class BookControllerTest {

    @Autowired // Mock MVC configurada em "@AutoConfigureMockMvc" e ativada aqui
    MockMvc mvc; // Objeto mockado. Esse objeto que vai estar mockando as requisições (Para simular)

    @Test
    @DisplayName("Deve criar um livro com sucesso. (POST)")
    public void createBookTest() {

    }

    @Test
    @DisplayName("Deve criar um livro sem sucesso. (POST)")
    public void createInvalidBookTest() {

    }

}
