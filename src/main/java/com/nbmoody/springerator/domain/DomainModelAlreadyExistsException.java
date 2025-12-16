package com.nbmoody.springerator.domain;

public class DomainModelAlreadyExistsException extends RuntimeException {
        public DomainModelAlreadyExistsException(String isbn) {
            super("A book with ISBN " + isbn + " already exists.");
        }
}
