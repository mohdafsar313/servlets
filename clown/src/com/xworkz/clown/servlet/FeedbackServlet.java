package com.xworkz.clown.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/feedback",loadOnStartup = 1)
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String mobile=req.getParameter("mobile");
        String rating=req.getParameter("rating");
        String message=req.getParameter("message");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");

        RequestDispatcher requestDispatcher=
                req.getRequestDispatcher("feedbackSuccess.jsp");
        req.setAttribute("message","Feedback Successfully saved");
        req.setAttribute("name",name);
        req.setAttribute("email",email);
        req.setAttribute("mobile",mobile);
        req.setAttribute("rating",rating);
        req.setAttribute("message",message);
        requestDispatcher.forward(req,resp);
    }
}
