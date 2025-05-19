package com.xworkz.clown.servlet;

import Dto.DonationDto;
import Dto.FirDto;
import com.xworkz.clown.servlet.service.DonationService;
import com.xworkz.clown.servlet.service.DonationServiceImpl;
import com.xworkz.clown.servlet.service.FirService;
import com.xworkz.clown.servlet.service.FirServiceImpl;

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
        String location=req.getParameter("location");
        String crimeType=req.getParameter("crimeType");
        System.out.println("using request dispatcher to forward the req and res to another jsp/servlet");
        FirDto firDto=new FirDto();
        firDto.setComplaintname(Complaintname);
        firDto.setDateofincident(dateofincident);
        firDto.setLocation(location);
        firDto.setCrimeType(crimeType);

        System.out.println("firDto:"+firDto);
        FirService firService = new FirServiceImpl();
        boolean saved = firService.save(firDto);
        if (saved) {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("firSuccess.jsp");


            req.setAttribute("message", "Fir Success");
            req.setAttribute("firDto", firDto);
            requestDispatcher.forward(req, resp);

        }
        else{
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("fir.jsp");
            req.setAttribute("message", "Saving of fir Failed");
        }
    }
}
