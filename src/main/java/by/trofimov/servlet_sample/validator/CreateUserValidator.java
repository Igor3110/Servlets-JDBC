package by.trofimov.servlet_sample.validator;

import by.trofimov.servlet_sample.dto.CreateUserDto;

public final class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    private CreateUserValidator() {}

    @Override
    public ValidationResult isValid(CreateUserDto createUserDto) {
        ValidationResult validationResult = new ValidationResult();
        String age = createUserDto.getAge();
        if (!isDigit(age)) {
            validationResult.add(Error.of("invalid.age", "Age is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

    private static boolean isDigit(String str) throws NumberFormatException {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
