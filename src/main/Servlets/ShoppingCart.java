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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "shoppingmapping")
public class ShoppingCart extends HttpServlet {
    @EJB
    ProductInterface productInterface;
    @EJB
    ShoppingInterface shoppingInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewCatalog.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();

        HttpSession session = req.getSession(false);
        String sessName = String.valueOf(session.getAttribute("EmailCustomer"));
        String[] products = req.getParameterValues("chB");
        for (int i = 0; i < products.length; i++) {

            Product product = productInterface.selectByName(products[i]);


            String pro_name = product.getProduct_name();
            String pro_price = product.getProduct_price();
            String pro_author = product.getProduct_author();

            Shopping shopping = new Shopping(sessName, pro_name, pro_price, pro_author);

            if (shoppingInterface.addCart(shopping) == true) {
                resp.sendRedirect("viewshopping");
            } else {
                pr.println("could not add catalog");
                pr.println("<html><body><p><a href=\"viewCatalog.jsp\">  Try Again </a></p></body></html>");
            }


        }
    }
}
