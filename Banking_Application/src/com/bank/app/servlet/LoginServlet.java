package com.bank.app.servlet;

import com.bank.app.dto.UserDTO;
import com.bank.app.service.UserService;
import com.bank.app.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (!userService.isValidLogin(email, password)) {
            req.setAttribute("error", "Invalid login details. Email or password format is incorrect.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        UserDTO user = userService.login(email, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("dashboard.jsp");
        } else {
            req.setAttribute("error", "Login failed! Please check your credentials.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
