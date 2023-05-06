package com.svalero.bookreactive.service;

import com.svalero.bookreactive.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Flux<Book> findAll();
    Mono<Book> findByIsbn(String isbn);
    Mono<Book> addBook(Book book);
}
