package by.trofimov.servlet_sample.service;

import by.trofimov.servlet_sample.dao.UserDAOImpl;
import by.trofimov.servlet_sample.dto.CreateUserDto;
import by.trofimov.servlet_sample.entity.User;
import by.trofimov.servlet_sample.mapper.CreateUserMapper;
import by.trofimov.servlet_sample.exception.ValidationException;
import by.trofimov.servlet_sample.validator.CreateUserValidator;
import by.trofimov.servlet_sample.validator.ValidationResult;

import java.util.List;

public final class UserService {

    private static final UserService INSTANCE = new UserService();
    private final UserDAOImpl userDAO = UserDAOImpl.getInstance();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    private UserService() {}

    public Integer create(CreateUserDto createUserDto) {
        ValidationResult validationResult = createUserValidator.isValid(createUserDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        User userEntity = createUserMapper.mapFrom(createUserDto);
        userDAO.save(userEntity);
        return userEntity.getId();
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

}
