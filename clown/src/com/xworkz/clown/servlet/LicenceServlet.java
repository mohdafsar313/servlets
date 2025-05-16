package com.xworkz.clown.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/licence",loadOnStartup = 1)
public class LicenceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String mobile=req.getParameter("mobile");
        String licenseType=req.getParameter("licenseType");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");

        RequestDispatcher requestDispatcher=
                req.getRequestDispatcher("licenceSuccess.jsp");
        req.setAttribute("message","Licence Successfully Completed");
        req.setAttribute("name",name);
        req.setAttribute("email",email);
        req.setAttribute("mobile",mobile);
        req.setAttribute("licenseType",licenseType);
        requestDispatcher.forward(req,resp);
    }
}
