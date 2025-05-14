import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        urlPatterns = {"/enroll"}
)

public class EnrollServlet extends GenericServlet {
    public EnrollServlet() {
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String name = servletRequest.getParameter("name");
        String age = servletRequest.getParameter("age");
        int p_age = 0;
        if (age != null && age != "") {
            p_age = Integer.parseInt(age);
        }

        String membership = servletRequest.getParameter("membership");
        int duration = 0;
        switch (membership) {
            case "Monthly":
                duration = 1;
                break;
            case "Quarterly":
                duration = 3;
                break;
            case "Yearly":
                duration = 12;
        }

        String fee = servletRequest.getParameter("fee");
        p_fee = 0;
        if (fee != null && fee != "") {
            p_fee = Integer.parseInt(fee);
        }

        int totalAmount = p_fee * duration;
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<h1>Welcome to FitZone, </h1>" + name + "");
        writer.println("<h3>Age: </h3>" + age + "");
        writer.println("<h3>Membership Type: </h3>" + membership + "");
        writer.println("<h3>Monthly Fee: Rs. </h3>" + fee + "");
        writer.println("<h2>Total Payable Amount: </h2>" + totalAmount + "");
    }
}
