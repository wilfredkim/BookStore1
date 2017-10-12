import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.awt.print.Printable;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Stateless
@Local
public class ProductOperation implements ProductInterface{
    @EJB
    DbConnectInterface dbConnect;

    public boolean addProduct(Product produt) {
        //DbConnect dbConnect = new DbConnect();

        String sql = "INSERT into product(Name,Author,Price) values(?,?,?)";
        PreparedStatement pst = dbConnect.createprepareStatement(sql);

        try {
            pst.setString(1, produt.getProduct_name());
            pst.setString(2, produt.getProduct_author());
            pst.setString(3, produt.getProduct_price());
            dbConnect.dbWrite(pst);
            //dbConnect.dbClose();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    public ArrayList<Product> viewProduct() {
        //DbConnect dbConnect = new DbConnect();
        ArrayList<Product> pList = new ArrayList<Product>();

        String sql = "SELECT * from product";
        try {
            ResultSet rs = dbConnect.dbRead(sql);
            while (rs.next() && rs != null) {
                Product p = new Product();
                p.setProduct_name(rs.getString("Name"));
                p.setProduct_author(rs.getString("Author"));
                p.setProduct_price(rs.getString("Price"));
                pList.add(p);


            }
            //dbConnect.dbClose();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pList;

    }






    public Product selectByName(String name) {
        Product p = new Product();
        //DbConnect dbConnect = new DbConnect();

        String sql = "SELECT Name,Price,Author from product where Name='" + name + "'";
        ResultSet rs = dbConnect.dbRead(sql);
        try {
            while (rs.next() && rs!=null) {
                p.setProduct_name(rs.getString("Name"));
                p.setProduct_price(rs.getString("Price"));
                p.setProduct_author(rs.getString("Author"));

            }
            //dbConnect.dbClose();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
