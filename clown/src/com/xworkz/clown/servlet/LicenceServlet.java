package com.xworkz.clown.servlet;

import Dto.FirDto;
import Dto.LicenceDto;
import com.xworkz.clown.servlet.service.DonationService;
import com.xworkz.clown.servlet.service.DonationServiceImpl;
import com.xworkz.clown.servlet.service.LicenceService;
import com.xworkz.clown.servlet.service.LicenceServiceImpl;

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
        LicenceDto licenceDto=new LicenceDto();
        licenceDto.setName(name);
        licenceDto.setEmail(email);
        licenceDto.setMobile(mobile);
        licenceDto.setLicenseType(licenseType);
        LicenceService licenceService = new LicenceServiceImpl();
        boolean saved = licenceService.save(licenceDto);
        if(saved) {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("licenceSuccess.jsp");
            req.setAttribute("message", "Licence Successfully Completed");
            req.setAttribute("licenceDto", licenceDto);
            requestDispatcher.forward(req, resp);
        }
        else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("licence.jsp");
            req.setAttribute("message", "Saving of Licence Failed");
        }
    }
}
