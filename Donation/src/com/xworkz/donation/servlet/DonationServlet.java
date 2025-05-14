package com.xworkz.donation.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.security.SecureRandom;
@WebServlet(urlPatterns = "/donate",loadOnStartup = 1)
public class DonationServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("running service in donationservlet");
        String name=servletRequest.getParameter("name");
        String email=servletRequest.getParameter("email");
        String cause=servletRequest.getParameter("cause");
        String mobile=servletRequest.getParameter("mobile");
        Long mob = 0L;
        if (mobile!=null && mobile!=" "){
            mob=Long.parseLong(mobile);
        }
        System.out.println("name: "+name+" email: "+email+" cause: "+cause+" mobile: "+mob);
    }
}
