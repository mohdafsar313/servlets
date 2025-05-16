package com.xworkz.clown.servlet;

import sun.security.timestamp.HttpTimestamper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/laboratory",loadOnStartup = 1)
public class LaboratoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String location=req.getParameter("location");
        String mobile=req.getParameter("mobile");
        String treatment=req.getParameter("treatment");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");

        RequestDispatcher requestDispatcher=
                req.getRequestDispatcher("laboratorySuccess.jsp");
        req.setAttribute("message","Laboratory registration");
        req.setAttribute("name",name);
        req.setAttribute("location",location);
        req.setAttribute("mobile",mobile);
        req.setAttribute("treatment",treatment);
        requestDispatcher.forward(req,resp);
    }
}
