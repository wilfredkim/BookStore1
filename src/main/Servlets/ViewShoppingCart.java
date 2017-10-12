import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "viewshopping")
public class ViewShoppingCart extends HttpServlet {
   @EJB
    ShoppingInterface shoppingInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     ArrayList<Shopping> list = shoppingInterface.viewShopping();
     req.setAttribute("shoppinglist",list);
        RequestDispatcher dispatcher= req.getRequestDispatcher("viewShoppingcart.jsp");
        dispatcher.forward(req,resp);
    }}
