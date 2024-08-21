package by.trofimov.servlet_sample.servlet;

import java.io.IOException;
import by.trofimov.servlet_sample.dto.CreateUserDto;
import by.trofimov.servlet_sample.exception.ValidationException;
import by.trofimov.servlet_sample.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.trofimov.servlet_sample.util.JspHelper;

import static by.trofimov.servlet_sample.util.Constant.*;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("addUser")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(USER_FIRST_NAME);
        String lastName = req.getParameter(USER_LAST_NAME);
        System.out.println(firstName + "," + lastName);
        String age = req.getParameter(USER_AGE);
        String company = req.getParameter(USER_COMPANY);
        CreateUserDto createUseDto = CreateUserDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .company(company)
                .build();
        try {
            userService.create(createUseDto);
            resp.sendRedirect("/");
        } catch (ValidationException e) {
            req.setAttribute(ERRORS, e.getErrors());
            doGet(req, resp);
        }
    }

}
