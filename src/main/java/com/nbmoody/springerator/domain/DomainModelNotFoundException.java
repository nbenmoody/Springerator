package com.nbmoody.springerator.domain;

public class DomainModelNotFoundException extends RuntimeException {
    public DomainModelNotFoundException(String isbn) {
        super("The book with ISBN " + isbn + " was not found.");
    }
}
