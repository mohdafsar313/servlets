package servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ContactServlet extends GenericServlet {

    @Override

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("running service in ContactServlet");

        String firstname=servletRequest.getParameter("firstname");

        String lastname=servletRequest.getParameter("lastname");

        String email=servletRequest.getParameter("email");

        String age=servletRequest.getParameter("message");

    }
}
