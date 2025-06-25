package com.bank.app.servlet;

import com.bank.app.dto.UserDTO;
import com.bank.app.dto.PassbookEntryDTO;
import com.bank.app.service.UserService;
import com.bank.app.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/passbook")
public class PassbookServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        UserDTO user = (UserDTO) session.getAttribute("user");
        List<PassbookEntryDTO> transactions = userService.getTransactions(user);

        req.setAttribute("transactions", transactions);
        req.getRequestDispatcher("passbook.jsp").forward(req, resp);
    }
}
