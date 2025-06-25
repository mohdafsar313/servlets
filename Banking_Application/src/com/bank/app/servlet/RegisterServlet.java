package com.bank.app.servlet;

import com.bank.app.dto.UserDTO;
import com.bank.app.service.UserService;
import com.bank.app.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDTO user = new UserDTO();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setBalance(0.0);

        if (!userService.isValidRegistration(user)) {
            req.setAttribute("error", "Invalid input! Make sure email is valid and password is at least 6 characters.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        boolean registered = userService.registerUser(user);

        if (registered) {
            req.setAttribute("message", "Registration successful! Please log in.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Registration failed! Email might already be used.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
