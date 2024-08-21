package by.trofimov.servlet_sample.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import by.trofimov.servlet_sample.entity.User;
import by.trofimov.servlet_sample.util.ConnectionManager;
import lombok.SneakyThrows;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static by.trofimov.servlet_sample.util.Constant.*;

public final class UserDAOImpl implements UserDAO<Integer, User> {

    private static final UserDAOImpl INSTANCE = new UserDAOImpl();

    private UserDAOImpl() {}

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            prepareStatement.setObject(1, entity.getAge());
            prepareStatement.setObject(2, entity.getCompany());
            prepareStatement.setObject(3, entity.getFirstName());
            prepareStatement.setObject(4, entity.getLastName());
            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject(USER_ID, Integer.class));
        }
        return entity;
    }

    @Override
    @SneakyThrows
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(USER_ID));
                user.setFirstName(resultSet.getString(USER_FIRST_NAME));
                user.setLastName(resultSet.getString(USER_LAST_NAME));
                user.setAge(resultSet.getInt(USER_AGE));
                user.setCompany(resultSet.getString(USER_COMPANY));
                users.add(user);
            }
        }
        return users;
    }

    public static UserDAOImpl getInstance() {
        return INSTANCE;
    }

}
