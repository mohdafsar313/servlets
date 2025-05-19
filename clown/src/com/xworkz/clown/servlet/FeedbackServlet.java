package com.xworkz.clown.servlet;

import Dto.FeedbackDto;
import Dto.FirDto;
import com.xworkz.clown.servlet.service.DonationService;
import com.xworkz.clown.servlet.service.DonationServiceImpl;
import com.xworkz.clown.servlet.service.FeedbackService;
import com.xworkz.clown.servlet.service.FeedbackServiceImpl;

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
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String rating = req.getParameter("rating");
        String message = req.getParameter("message");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setName(name);
        feedbackDto.setEmail(email);
        feedbackDto.setMobile(mobile);
        feedbackDto.setRating(rating);
        feedbackDto.setMessage(message);
        FeedbackService feedbackService = new FeedbackServiceImpl();
        boolean saved = feedbackService.save(feedbackDto);

        if (saved) {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("feedbackSuccess.jsp");
            req.setAttribute("message", "Feedback Successfully saved");
            req.setAttribute("feedbackDto", feedbackDto);
            requestDispatcher.forward(req, resp);
        }
        else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("feedback.jsp");
            req.setAttribute("message", "Saving of Donation Failed");
        }
    }
}
