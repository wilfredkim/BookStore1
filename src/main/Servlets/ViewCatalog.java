import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(urlPatterns = "viewcatalogmapping")
public class ViewCatalog extends HttpServlet {
    @EJB
    ProductInterface productInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> list  = productInterface.viewProduct();
        req.setAttribute("viewcataloglist",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewCatalog.jsp");
        dispatcher.forward(req,resp);
    }
}
