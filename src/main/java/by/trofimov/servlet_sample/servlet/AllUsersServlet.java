package by.trofimov.servlet_sample.servlet;

import java.io.IOException;
import by.trofimov.servlet_sample.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.trofimov.servlet_sample.util.JspHelper;

import static by.trofimov.servlet_sample.util.Constant.USERS;

@WebServlet("/")
public class AllUsersServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(USERS, userService.findAll());
        req.getRequestDispatcher(JspHelper.getPath("allUsers")).forward(req, resp);
    }

}
