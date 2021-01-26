package com.lucasangelo.libraryapi.api.dto;

import lombok.*;

// Padrão DTO é apenas uma classe simples (com atributos simples) utilizada para representar tratar JSON
// Utilizado para converter JSON em objeto
@Getter // Do lombok, para não precisar ficar criando os métodos de get
@Setter // Do lombok, para não precisar ficar criando os métodos de set
@Builder // Do lombok, para cria o contrutor
@NoArgsConstructor // Para construtor sem parâmetros funcionar
@AllArgsConstructor // E um com todos os argumentos no construtor
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;

}
