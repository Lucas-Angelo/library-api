package com.lucasangelo.libraryapi.api.resource;

import com.lucasangelo.libraryapi.api.dto.BookDTO;
import com.lucasangelo.libraryapi.model.entity.Book;
import com.lucasangelo.libraryapi.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // API vai ser controlada por esse rest
@RequestMapping("/api/books") // Esta será a rota da API
public class BookController {

    private BookService service;
    private ModelMapper modelMapper;

    public BookController(BookService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping // Esse método vai tratar requisão do tipo POST, para a rota: "/api/books"
    @ResponseStatus(HttpStatus.CREATED) // Para retornar CREATED 201 quando der sucesso
    public BookDTO create( @RequestBody BookDTO dto ) {

        // ModelMapper cria uma instância Book (que precisamos), por meio do BookDTO que recebemos
        Book entity = modelMapper.map(dto, Book.class); // Transfere todas as propriedades de mesmo nome do dto pro book

        // ModelMapper faz isso (Essa forma é feita com o construtor do lombok e gets e sets)
//        Book entity = Book.builder()
//                        .author(dto.getAuthor())
//                        .title(dto.getTitle())
//                        .isbn(dto.getIsbn())
//                        .build();

        entity = service.save(entity); // Salva a instância de Book

        return modelMapper.map(entity, BookDTO.class); // Precisa retornar o DTO, dai transforma

        // ModelMapper faz isso (Essa forma é feita com o construtor do lombok e gets e sets)
//        return BookDTO.builder()
//                    .id(entity.getId())
//                    .author(entity.getAuthor())
//                    .title(entity.getTitle())
//                    .isbn(entity.getIsbn())
//                    .build();
    }

}
