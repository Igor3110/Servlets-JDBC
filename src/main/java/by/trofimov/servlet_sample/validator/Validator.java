package by.trofimov.servlet_sample.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);

}
