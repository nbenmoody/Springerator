package com.nbmoody.springerator.web;

import com.nbmoody.springerator.domain.DomainModel;
import com.nbmoody.springerator.domain.DomainService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("domainmodels")
public class DomainController {
    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @GetMapping
    public Iterable<DomainModel> get() {
        return domainService.viewDomainModelList();
    }

    @GetMapping("{isbn}")
    public DomainModel getByIsbn(@PathVariable String isbn) {
        return domainService.viewDomainModelDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DomainModel post(@Valid @RequestBody DomainModel domainModel) {
        return domainService.addDomainModelToCatalog(domainModel);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        domainService.removeDomainModelFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public DomainModel put(@PathVariable String isbn,@Valid @RequestBody DomainModel domainModel) {
        return domainService.editDomainDetails(isbn, domainModel);
    }
}
