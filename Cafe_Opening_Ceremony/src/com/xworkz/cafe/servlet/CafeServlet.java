package com.xworkz.cafe.servlet;

import com.xworkz.cafe.dto.CafeDto;
import com.xworkz.cafe.service.CafeService;
import com.xworkz.cafe.service.CafeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(urlPatterns = {"/cafe", "/cafeSearch"}, loadOnStartup = 1)
public class CafeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cafeName = req.getParameter("cafeName");
        String ownerName = req.getParameter("ownerName");

        String estDateStr = req.getParameter("establishedDate");
        LocalDate establishedDate = null;
        if (estDateStr != null && !estDateStr.isEmpty()) {
            establishedDate = LocalDate.parse(estDateStr);
        }

        String cuisineType = req.getParameter("cuisineType");
        String hasWiFi = req.getParameter("hasWiFi");

        CafeDto cafeDto = new CafeDto(cafeName, ownerName, establishedDate, cuisineType, hasWiFi);

        CafeService cafeService = new CafeServiceImpl();
        boolean valid = cafeService.save(cafeDto);

        if (valid) {
            System.out.println("Cafe service executed successfully.");
            req.setAttribute("dto", cafeDto );
            req.setAttribute("success", "Cafe Details Saved Successfully");
        } else {
            System.out.println("Cafe data not saved.");
            req.setAttribute("dto", cafeDto);
            req.setAttribute("failure", "Failed to Save Cafe Details");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/cafe.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Running GET in CafeServlet...");

        String cafeId = req.getParameter("cafeId");
        if (cafeId != null) {
            int id = Integer.parseInt(cafeId);
            System.out.println("Searching Cafe with ID: " + id);

            CafeService cafeService = new CafeServiceImpl();
            Optional<CafeDto> optionalCafeDTO = cafeService.findById(id);

            if (optionalCafeDTO.isPresent()) {
                CafeDto cafeDto = optionalCafeDTO.get();
                System.out.println("Cafe data found: " + cafeDto);
                req.setAttribute("dto", cafeDto);
            } else {
                System.out.println("No Cafe data found for ID: " + id);
                req.setAttribute("failure", "No Cafe found with ID: " + id);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/cafe.jsp");
            dispatcher.forward(req, resp);
        }
    }
}

