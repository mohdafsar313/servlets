package com.xworkz.clown.servlet;

import Dto.FirDto;
import Dto.LaboratoryDto;
import com.xworkz.clown.servlet.service.DonationService;
import com.xworkz.clown.servlet.service.DonationServiceImpl;
import com.xworkz.clown.servlet.service.LaboratoryService;
import com.xworkz.clown.servlet.service.LaboratoryServiceImpl;
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
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        String mobile = req.getParameter("mobile");
        String treatment = req.getParameter("treatment");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");
        LaboratoryDto laboratoryDto = new LaboratoryDto();
        laboratoryDto.setName(name);
        laboratoryDto.setLocation(location);
        laboratoryDto.setMobile(mobile);
        laboratoryDto.setTreatment(treatment);
        LaboratoryService laboratoryService = new LaboratoryServiceImpl();
        boolean saved = laboratoryService.save(laboratoryDto);
        if (saved) {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("laboratorySuccess.jsp");
            req.setAttribute("message", "Laboratory registration");
            req.setAttribute("laboratoryDto", laboratoryDto);
            requestDispatcher.forward(req, resp);
        }
        else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("donation.jsp");
            req.setAttribute("message", "Saving of Donation Failed");
        }
    }
}
