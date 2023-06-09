package com.svalero.bookreactive.exception;

public class BookNotFoundException extends Exception{

    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
