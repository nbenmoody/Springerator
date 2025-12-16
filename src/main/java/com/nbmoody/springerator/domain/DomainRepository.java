package com.nbmoody.springerator.domain;

import java.util.Optional;
public interface DomainRepository {
    Iterable<DomainModel> findAll();
    Optional<DomainModel> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    DomainModel save(DomainModel book);
    void deleteByIsbn(String isbn);
}
