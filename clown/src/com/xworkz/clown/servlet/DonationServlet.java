package com.xworkz.clown.servlet;

import Dto.DonationDto;
import com.xworkz.clown.servlet.service.DonationService;
import com.xworkz.clown.servlet.service.DonationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/donation",loadOnStartup = 1)
public class DonationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String amount = req.getParameter("amount");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");
        DonationDto donationDto = new DonationDto();
        donationDto.setName(name);
        donationDto.setEmail(email);
        donationDto.setMobile(mobile);
        donationDto.setAmount(amount);
        System.out.println("DonationDto:" + donationDto);
        DonationService donationService = new DonationServiceImpl();
        boolean saved = donationService.save(donationDto);
        if (saved) {

            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("donationSuccess.jsp");
            req.setAttribute("message", "Donation Success");
            req.setAttribute("donationDto", donationDto);
            requestDispatcher.forward(req, resp);

        }
            else{
                RequestDispatcher requestDispatcher =
                        req.getRequestDispatcher("donation.jsp");
                req.setAttribute("message", "Saving of Donation Failed");
            }
        }
    }
