package com.xworkz.clown.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/fir",loadOnStartup = 1)
public class FirServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Complaintname=req.getParameter("complaintname");
        String dateofincident=req.getParameter("dateofincident");
        String Location=req.getParameter("Location");
        String crimeType=req.getParameter("crimeType");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");

        RequestDispatcher requestDispatcher=
                req.getRequestDispatcher("firSuccess.jsp");
        req.setAttribute("message","FIR registration");
        req.setAttribute("complaintname",Complaintname);
        req.setAttribute("dateofincident",dateofincident);
        req.setAttribute("Location",Location);
        req.setAttribute("crimeType",crimeType);
        requestDispatcher.forward(req,resp);
    }
}
