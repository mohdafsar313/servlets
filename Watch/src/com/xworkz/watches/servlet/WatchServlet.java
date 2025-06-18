package com.xworkz.watches.servlet;

import com.xworkz.watches.dto.WatchDto;
import com.xworkz.watches.service.WatchService;
import com.xworkz.watches.service.WatchServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(urlPatterns = "/WatchServlet", loadOnStartup = 1)
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
        String mfgDate = req.getParameter("mfgDate");
        String smart = req.getParameter("smart");
        String warranty = req.getParameter("warranty");

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
        if (mfgDate == null || mfgDate.trim().isEmpty()) {
            hasErrors = true;
            errors.append("Manufacture Date is required.<br>");
        }
        if (smart == null || smart.trim().isEmpty()) {
            hasErrors = true;
            errors.append("Please select if it is Smart.<br>");
        }
        int warrantyYears = 0;
        try {
            warrantyYears = Integer.parseInt(warranty);
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
        dto.setMfgDate(LocalDate.parse(mfgDate));
        dto.setSmart(smart);
        dto.setWarranty(warrantyYears);

        if (hasErrors) {
            req.setAttribute("message", errors.toString());
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("watches.jsp").forward(req, resp);
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
            req.getRequestDispatcher("watches.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("running get in WatchServlet..");
        String watchId= req.getParameter("watchId");
        if(watchId!=null)
        {
            int id=Integer.parseInt(watchId);
            System.out.println("search id :"+id);
            WatchService watchService=new WatchServiceImpl();
                Optional<WatchDto> optionalWatchDTO= watchService.findById(id);
            if(optionalWatchDTO.isPresent())
            {
                System.out.println("watch data is found");
            }
            else{
                System.out.println("watch data is not found for id :"+id);
            }
        }
    }
}
