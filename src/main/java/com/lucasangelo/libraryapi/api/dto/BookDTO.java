package com.lucasangelo.libraryapi.api.dto;

import lombok.Getter;
import lombok.Setter;

// Padrão DTO é apenas uma classe simples (com atributos simples) utilizada para representar tratar JSON
// Utilizado para converter JSON em objeto
@Getter // Do lombok, para não precisar ficar criando os métodos de get
@Setter // Do lombok, para não precisar ficar criando os métodos de set
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;

}
