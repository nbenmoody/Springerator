package com.nbmoody.springerator;

import com.nbmoody.springerator.domain.DomainModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;


class DomainModelValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var domainModel =
                new DomainModel("1234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<DomainModel>> violations = validator.validate(domainModel);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails() {
        var domainModel =
                new DomainModel("a234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<DomainModel>> violations = validator.validate(domainModel);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid.");
    }
}