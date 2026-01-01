package com.nbmoody.springerator.domain;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DomainService {
    private final DomainRepository domainRepository;

    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public Iterable<DomainModel> viewDomainModelList() {
        return domainRepository.findAll();
    }

    // Uses a cache called 'value' with the given key, or all method args by default.
    @Cacheable(value = "domainModelCache", key = "#isbn")
    public DomainModel viewDomainModelDetails(String isbn) {
        return domainRepository.findByIsbn(isbn)
                .orElseThrow(() -> new DomainModelNotFoundException(isbn));
    }

    public DomainModel addDomainModelToCatalog(DomainModel domainModel) {
        if (domainRepository.existsByIsbn(domainModel.isbn())) {
            throw new DomainModelAlreadyExistsException(domainModel.isbn());
        }
        return domainRepository.save(domainModel);
    }

    public void removeDomainModelFromCatalog(String isbn) {
        domainRepository.deleteByIsbn(isbn);
    }

    public DomainModel editDomainDetails(String isbn, DomainModel domainModel) {
        return domainRepository.findByIsbn(isbn)
                .map(existingDomainModel -> {
                    var domainModelToUpdate = new DomainModel(
                            existingDomainModel.isbn(),
                            domainModel.title(),
                            domainModel.author(),
                            domainModel.price());
                    return domainRepository.save(domainModelToUpdate);
                })
                .orElseGet(() -> addDomainModelToCatalog(domainModel));
    }
}
