package by.trofimov.servlet_sample.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    public static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "db.url";
    public static final String DB_USERNAME = "db.username";
    public static final String DB_PASSWORD = "db.password";

    public static final String APPLICATION_PROPERTIES_FILE = "application.properties";

    public static final String JSP_PATH = "/WEB-INF/template/%s.jsp";

    public static final String USERS = "users";
    public static final String ERRORS = "errors";

    public static final String USER_ID = "id";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_AGE = "age";
    public static final String USER_COMPANY = "company";

    public static final String SAVE_SQL = """
                INSERT INTO users
                (age, company, first_name, last_name)
                VALUES (?, ?, ?, ?)
            """;

    public static final String FIND_ALL_SQL = """
                SELECT * FROM users
            """;

}
