package com.lucasangelo.libraryapi.api.resource;

import com.lucasangelo.libraryapi.api.dto.BookDTO;
import com.lucasangelo.libraryapi.model.entity.Book;
import com.lucasangelo.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // API vai ser controlada por esse rest
@RequestMapping("/api/books") // Esta será a rota da API
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping // Esse método vai tratar requisão do tipo POST, para a rota: "/api/books"
    @ResponseStatus(HttpStatus.CREATED) // Para retornar CREATED 201 quando der sucesso
    public BookDTO create( @RequestBody BookDTO dto ) {
        Book entity = Book.builder()
                        .author(dto.getAuthor())
                        .title(dto.getTitle())
                        .isbn(dto.getIsbn())
                        .build();

        entity = service.save(entity);

        return BookDTO.builder()
                    .id(entity.getId())
                    .author(entity.getAuthor())
                    .title(entity.getTitle())
                    .isbn(entity.getIsbn())
                    .build();
    }

}
