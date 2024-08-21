package by.trofimov.servlet_sample.util;

import java.io.InputStream;
import java.util.Properties;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import static by.trofimov.servlet_sample.util.Constant.APPLICATION_PROPERTIES_FILE;

@UtilityClass
public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    @SneakyThrows
    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream(APPLICATION_PROPERTIES_FILE)) {
            PROPERTIES.load(inputStream);
        }
    }

}
