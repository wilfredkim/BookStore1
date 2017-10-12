import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "logincustomermapping")
public class LoginCustomer extends HttpServlet {
  @EJB
  CustomerInterface customerInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("loginCustomer.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String mail = req.getParameter("email");
        String password = req.getParameter("pass");
        if (customerInterface.authenticateCustomer(mail, password) == true) {
            HttpSession session = req.getSession();
            session.setAttribute("EmailCustomer", mail);
            resp.sendRedirect("customerPage.jsp");
        } else {
            out.println("Incorrect password");
            out.println("<html><body><p><a href=\"loginCustomer.jsp\">  Try Again </a></p></body></html>");

        }
    }
}
