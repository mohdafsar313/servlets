package com.xworkz.duster.servlet;

import com.xworkz.duster.dto.DusterDTO;
import com.xworkz.duster.service.DusterService;
import com.xworkz.duster.service.DusterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(urlPatterns = {"/move","/search"}, loadOnStartup = 1)
public class DusterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String material=req.getParameter("material");

        String color=req.getParameter("color");

        String price=req.getParameter("cost");
        int cost=0;
        if(price!=null){
            cost=Integer.parseInt(price);
        }

        String man=req.getParameter("dateOfManufac");
        LocalDate dateOfManufac=null;
        if(man!=null) {
            dateOfManufac = LocalDate.parse(man);
        }



        String quant=req.getParameter("quantity");
        int quantity=0;
        if(quant!=null){
            quantity=Integer.parseInt(quant);
        }
        String isUseful=req.getParameter("isUseful");
        DusterDTO dusterDTO=new DusterDTO(material,color,cost,dateOfManufac,quantity,isUseful);

        DusterService dusterService= new DusterServiceImpl();
        boolean valid=dusterService.save(dusterDTO);

        if(valid){
            System.out.println("service done successfully");
            req.setAttribute("dto",dusterDTO);
            req.setAttribute("success","Duster Details Saved Successfully");
        }
        else{
            System.out.println("not saved");
            req.setAttribute("dto",dusterDTO);
            req.setAttribute("failure","Duster Details not saved Successfully");
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/form.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("running get in DusterServlet..");
        String dusterId= req.getParameter("dusterId");
        if(dusterId!=null)
        {
            int id=Integer.parseInt(dusterId);
            System.out.println("search id :"+id);
            DusterService dusterService=new DusterServiceImpl();
            Optional<DusterDTO> optionalDusterDTO= dusterService.findById(id);
            if(optionalDusterDTO.isPresent())
            {
                DusterDTO dusterDTO=optionalDusterDTO.get();
                System.out.println("duster data is found :"+dusterDTO);

            }
            else{
                System.out.println("duster data is not found for id :"+id);
            }
        }
    }
}

