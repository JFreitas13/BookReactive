package com.svalero.bookreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "books")
public class Book {

    @Id
    private String id;
    @Field
    private String isbn;
    @Field
    private String name;
    @Field
    private int pages;
    @Field
    private String writer;
    @Field
    private String publisher;
    @Field
    private int yearEdition;



}
