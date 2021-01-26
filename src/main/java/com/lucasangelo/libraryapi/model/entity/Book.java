package com.lucasangelo.libraryapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Do lombok. Cria: @Getter, @Setter, @ToString, @EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private long id;
    private String title;
    private String author;
    private String isbn;

}
