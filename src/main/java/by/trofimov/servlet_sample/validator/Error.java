package by.trofimov.servlet_sample.validator;

import lombok.Value;

@Value(staticConstructor = "of")
public class Error {

    String code;
    String message;

}
