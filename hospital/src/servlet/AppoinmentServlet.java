package servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/appoint")
public class AppoinmentServlet extends GenericServlet {
    public AppoinmentServlet (){
        System.out.println("AppoinmentServlet  running in tomcat");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("running service in AppointmentServlet");

        String firstname=servletRequest.getParameter("firstname");
        String lastname=servletRequest.getParameter("lastname");

        String email=servletRequest.getParameter("email");

        String age=servletRequest.getParameter("age");

        String gender=servletRequest.getParameter("gender");

        String address=servletRequest.getParameter("address");

        String sickness=servletRequest.getParameter("sickness");

        String mobile_no=servletRequest.getParameter("mobile_no");
        long contact=0L;
        if(mobile_no!=null && mobile_no!=""){
            contact=Long.parseLong(mobile_no);
        }
        servletResponse.setContentType("text/html");
        PrintWriter writer= servletResponse.getWriter();

        writer.println("<h1> Thanks" +firstname+ " for booking a slot for"+sickness +"</h1>");
    }
}
