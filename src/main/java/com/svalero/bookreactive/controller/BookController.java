package com.svalero.bookreactive.controller;

import com.svalero.bookreactive.domain.Book;
import com.svalero.bookreactive.exception.BookNotFoundException;
import com.svalero.bookreactive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books", produces = MediaType.TEXT_EVENT_STREAM_VALUE) //flujo continuo de datos
    public Flux<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping(value = "/books/{isbn}")
    private Mono<ResponseEntity<Book>> getIsbn(@PathVariable("isbn") String isbn) throws BookNotFoundException {
        return this.bookService.findByIsbn(isbn)
                .flatMap(book -> Mono.just(ResponseEntity.ok(book)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book).block();
    }

}
