package com.xworkz.watches.servlet;

import com.xworkz.watches.dto.WatchDto;
import com.xworkz.watches.service.WatchService;
import com.xworkz.watches.service.WatchServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/watch", loadOnStartup = 1)
public class WatchServlet extends HttpServlet {

    public WatchServlet() {
        System.out.println("Running in WatchServlet constructor...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST method in WatchServlet");

        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String priceStr = req.getParameter("price");
        String manufactureDate = req.getParameter("manufactureDate");
        String isSmart = req.getParameter("isSmart");
        String warrantyYearsStr = req.getParameter("warrantyYears");

        boolean hasErrors = false;
        StringBuilder errors = new StringBuilder();

        if (brand == null || brand.trim().isEmpty()) {
            hasErrors = true;
            errors.append("Brand is required.<br>");
        }
        if (model == null || model.trim().isEmpty()) {
            hasErrors = true;
            errors.append("Model is required.<br>");
        }
        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
            if (price <= 0) {
                hasErrors = true;
                errors.append("Price must be greater than zero.<br>");
            }
        } catch (NumberFormatException e) {
            hasErrors = true;
            errors.append("Invalid price.<br>");
        }
        if (manufactureDate == null || manufactureDate.trim().isEmpty()) {
            hasErrors = true;
            errors.append("Manufacture Date is required.<br>");
        }
        if (isSmart == null || isSmart.trim().isEmpty()) {
            hasErrors = true;
            errors.append("Please select if it is Smart.<br>");
        }
        int warrantyYears = 0;
        try {
            warrantyYears = Integer.parseInt(warrantyYearsStr);
            if (warrantyYears <= 0) {
                hasErrors = true;
                errors.append("Warranty years must be greater than 0.<br>");
            }
        } catch (NumberFormatException e) {
            hasErrors = true;
            errors.append("Invalid warranty years.<br>");
        }

        WatchDto dto = new WatchDto();
        dto.setBrand(brand);
        dto.setModel(model);
        dto.setPrice(price);
        dto.setManufactureDate(manufactureDate);
        dto.setIsSmart(isSmart);
        dto.setWarrantyYears(warrantyYears);

        if (hasErrors) {
            req.setAttribute("message", errors.toString());
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("form.jsp").forward(req, resp);
            return;
        }

        WatchService service = new WatchServiceImpl();
        boolean saved = service.save(dto);

        if (saved) {
            req.setAttribute("message", "Watch details saved successfully!");
            req.setAttribute("details", dto);
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Something went wrong. Try again.");
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        }
    }
}
