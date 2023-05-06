package com.svalero.bookreactive.repository;

import com.svalero.bookreactive.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Flushable;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Flux<Book> findAll(); //lista de elementos
    Mono<Book> findByIsbn(String isbn); //un solo elemento. Un único elemento similar a Optional

}
