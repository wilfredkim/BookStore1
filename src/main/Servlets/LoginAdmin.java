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

@WebServlet(urlPatterns = "loginadminmapping")
public class LoginAdmin extends HttpServlet {
@EJB
AdminInterface adminInterface;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();

        String mail = req.getParameter("email");
        String password = req.getParameter("pass");
        if(adminInterface.authenticateAdmin(mail,password)==true){
            HttpSession session = req.getSession();
            session.setAttribute("EmailAdmin", mail);
            resp.sendRedirect("adminPage.jsp");
        } else{
            out.println("Incorrect password");
            out.println("<html><body><p><a href=\"loginAdmin.jsp\">  Try Again </a></p></body></html>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("loginAdmin.jsp");
        rd.forward(req,resp);
    }
}
