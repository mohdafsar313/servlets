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

        System.out.println(brand);
        System.out.println(model);
        System.out.println(priceStr);
        System.out.println(manufactureDate);
        System.out.println(isSmart);
        System.out.println(warrantyYearsStr);

        // Set request attributes
        req.setAttribute("brand", brand);
        req.setAttribute("model", model);
        req.setAttribute("price", priceStr);
        req.setAttribute("manufactureDate", manufactureDate);
        req.setAttribute("isSmart", isSmart);
        req.setAttribute("warrantyYears", warrantyYearsStr);

        // Parse numeric values
        double price = Double.parseDouble(priceStr);
        int warrantyYears = Integer.parseInt(warrantyYearsStr);

        // Create DTO and set values
        WatchDto dto = new WatchDto();
        dto.setBrand(brand);
        dto.setModel(model);
        dto.setPrice(price);
        dto.setManufactureDate(manufactureDate);
        dto.setIsSmart(isSmart);
        dto.setWarrantyYears(warrantyYears);

        // Save using service
        WatchService service = new WatchServiceImpl();
        boolean saved = service.save(dto);

        // Forward to JSP with message
        RequestDispatcher dispatcher = req.getRequestDispatcher("watches.jsp");
        req.setAttribute("message", "Watch details saved successfully!");
        dispatcher.forward(req, resp);

        System.out.println("Watch saved successfully");
    }
}
