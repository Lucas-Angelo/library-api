package com.lucasangelo.libraryapi.api.resource;

import com.lucasangelo.libraryapi.api.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController // API vai ser controlada por esse rest
@RequestMapping("/api/books") // Esta será a rota da API
public class BookController {

    @PostMapping // Esse método vai tratar requisão do tipo POST, para a rota: "/api/books"
    @ResponseStatus(HttpStatus.CREATED) // Para retornar CREATED 201 quando der sucesso
    public BookDTO create(){
        BookDTO dto = new BookDTO();
        dto.setId(1l);
        dto.setTitle("Meu livro");
        dto.setAuthor("Autor");
        dto.setIsbn("123");
        return dto;
    }

}
