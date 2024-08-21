package by.trofimov.servlet_sample.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static by.trofimov.servlet_sample.util.Constant.CONTENT_TYPE;

@WebFilter("/*")
public class MainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        resp.setContentType(CONTENT_TYPE);
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        filterChain.doFilter(req, resp);
    }

}
