package by.trofimov.servlet_sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import static by.trofimov.servlet_sample.util.Constant.*;

@UtilityClass
public class ConnectionManager {

    static {
        try {
            Class.forName(ORG_POSTGRESQL_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public static Connection get() {
            return DriverManager.getConnection(
                    PropertiesUtil.get(DB_URL),
                    PropertiesUtil.get(DB_USERNAME),
                    PropertiesUtil.get(DB_PASSWORD)
            );
    }

}
