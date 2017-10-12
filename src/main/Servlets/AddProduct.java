import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addProductt")
public class AddProduct extends HttpServlet {
    @EJB
    ProductInterface productInterface;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("addProduct.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();

        String prod_name = req.getParameter("prodname");
        String prod_price = req.getParameter("price");
        String prod_author = req.getParameter("author");
      Product products = new Product(prod_name,prod_price,prod_author);

      if(productInterface.addProduct(products)==true) {
          resp.sendRedirect("viewproductmapping");
      } else{
          pr.println("could not add product");
          pr.println("<html><body><p><a href=\"addProduct.jsp\">  Try Again </a></p></body></html>");
      }
    }
}
