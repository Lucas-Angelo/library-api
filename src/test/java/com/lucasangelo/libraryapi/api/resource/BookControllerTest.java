package com.lucasangelo.libraryapi.api.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// Serão feitos testes unitários aqui
// Configuração para criar um mini contexto para rodar o teste
@ExtendWith(SpringExtension.class) // O Controller do SpringBoot é feito assim
@ActiveProfiles("test") // Para algumas coisas rodar apenas nesses perfis marcos como "test"
@WebMvcTest
@AutoConfigureMockMvc // Spring faz uma configuração de um objeto para as requisições
public class BookControllerTest {

    static String BOOK_API = "/api/books"; // Rota padrão da API

    @Autowired // Mock MVC configurada em "@AutoConfigureMockMvc" e ativada aqui
    MockMvc mvc; // Objeto mockado. Esse objeto que vai estar mockando as requisições (Para simular)

    @Test
    @DisplayName("Deve criar um livro com sucesso. (POST)")
    public void createBookTest() throws Exception {

        String json = new ObjectMapper().writeValueAsString(null); // O write recebe objeto e retorna json

        // Classe usada para definir uma requisição
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(BOOK_API) // Vai ser um post, na rota padrão
                .contentType(MediaType.APPLICATION_JSON) // Vai passar um conteúdo tipo JSON
                .accept(MediaType.APPLICATION_JSON) // E o servidor vai aceitar o conteúdo JSON também
                .content(json); // O que vamos passar

        // Aqui irá fazer a requisição
        mvc
                .perform(request) // Utilizando o objeto que foi preparado
                .andExpect( MockMvcResultMatchers.status().isCreated() ) // Espera retornar o 201 CREATED
                .andExpect( MockMvcResultMatchers.jsonPath("id").isNotEmpty() ) // E espera receber o JSON criado também
                .andExpect( MockMvcResultMatchers.jsonPath("title").value("Meu livro") )
                .andExpect( MockMvcResultMatchers.jsonPath("isbn").value("123") ).andExpect( MockMvcResultMatchers.jsonPath("title").value("Meu livro") )
        ;

    }

    @Test
    @DisplayName("Deve criar um livro sem sucesso. (POST)")
    public void createInvalidBookTest() {

    }

}
