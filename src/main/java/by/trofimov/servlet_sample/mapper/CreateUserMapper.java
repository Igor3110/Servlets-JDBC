package by.trofimov.servlet_sample.mapper;

import by.trofimov.servlet_sample.entity.User;
import by.trofimov.servlet_sample.dto.CreateUserDto;

public final class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    private CreateUserMapper() {}

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .age(Integer.valueOf(object.getAge()))
                .company(object.getCompany())
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

}
