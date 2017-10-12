import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addCustomermapping")
public class AddCustomer extends HttpServlet {
@EJB
CustomerInterface customerInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("addCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String cust_name = req.getParameter("custname");
        String mail = req.getParameter("email");
        String password = req.getParameter("pass");
        String conpassword = req.getParameter("conpass");
        if (password.equals(conpassword)) {
            Customer customer = new Customer(cust_name, mail, password);

            if (customerInterface.register(customer) == true) {
                resp.sendRedirect("logincustomermapping");
            } else {
                out.println("Could not register");
                out.println("<html><body><p><a href=\"addCustomer.jsp\">  Try Again </a></p></body></html>");
            }

        } else {


            out.println("PassWord does not match");
            out.println("<html><body><p><a href=\"addCustomer.jsp\">  Try Again </a></p></body></html>");

        }
    }
}
