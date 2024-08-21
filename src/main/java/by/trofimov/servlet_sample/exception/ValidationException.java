package by.trofimov.servlet_sample.exception;

import java.util.List;
import by.trofimov.servlet_sample.validator.Error;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}
