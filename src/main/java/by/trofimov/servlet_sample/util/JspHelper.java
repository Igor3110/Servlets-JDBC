package by.trofimov.servlet_sample.util;

import lombok.experimental.UtilityClass;

import static by.trofimov.servlet_sample.util.Constant.JSP_PATH;

@UtilityClass
public class JspHelper {

    public static String getPath(String path) {
        return JSP_PATH.formatted(path);
    }

}
