package com.nbmoody.springerator.persistence;
 
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.nbmoody.springerator.domain.DomainModel;
import com.nbmoody.springerator.domain.DomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryDomainRepository implements DomainRepository {
    private static final Map<String, DomainModel> books =
            new ConcurrentHashMap<>();

    @Override
    public Iterable<DomainModel> findAll() {
        return books.values();
    }

    @Override
    public Optional<DomainModel> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) :
                Optional.empty();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public DomainModel save(DomainModel book) {
        books.put(book.isbn(), book);
        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
