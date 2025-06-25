package com.bank.app.servlet;

import com.bank.app.dto.UserDTO;
import com.bank.app.service.UserService;
import com.bank.app.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        UserDTO user = (UserDTO) session.getAttribute("user");
        String amountStr = req.getParameter("amount");

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid amount entered.");
            req.getRequestDispatcher("withdraw.jsp").forward(req, resp);
            return;
        }

        if (!userService.isValidAmount(amount)) {
            req.setAttribute("error", "Amount must be greater than 0.");
            req.getRequestDispatcher("withdraw.jsp").forward(req, resp);
            return;
        }

        if (amount > user.getBalance()) {
            req.setAttribute("error", "Insufficient balance.");
            req.getRequestDispatcher("withdraw.jsp").forward(req, resp);
            return;
        }

        boolean success = userService.withdraw(user, amount);

        if (success) {
            session.setAttribute("user", user); // update session with new balance
            req.setAttribute("message", "₹" + amount + " withdrawn successfully.");
        } else {
            req.setAttribute("error", "Withdrawal failed. Try again later.");
        }

        req.getRequestDispatcher("withdraw.jsp").forward(req, resp);
    }
}
