import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import  java.sql.*;
import java.util.ArrayList;

@Stateless
@Local
public class ShoppingOperation implements  ShoppingInterface{
    @EJB
    DbConnectInterface dbConnect;
    public ArrayList<Shopping> viewShopping() {
        //DbConnect dbConnect = new DbConnect();
        ArrayList<Shopping> sList  = new ArrayList<Shopping>();
        String sql = "SELECT * from shopping";

        ResultSet rs = dbConnect.dbRead(sql);
        try {
            while (rs.next()&& rs!=null) {
                Shopping shopping = new Shopping();
                shopping.setCust_name(rs.getString("Customer_Name"));
                shopping.setProd_name(rs.getString("Book"));
                shopping.setProd_price(rs.getString("Price"));
                shopping.setProd_author(rs.getString("Author"));
                sList.add(shopping);


            }
            //dbConnect.dbClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return  sList;
    }
    public boolean addCart(Shopping shopping){
      //DbConnect dbConnect = new DbConnect();
        String add  = "INSERT into shopping (Customer_Name,Book,Price,Author) values(?,?,?,?)";
        PreparedStatement pst  = dbConnect.createprepareStatement(add);
        try{


                pst.setString(1,shopping.getCust_name());
                pst.setString(2,shopping.getProd_name());
                pst.setString(3,shopping.getProd_price());
                pst.setString(4,shopping.getProd_author());
                dbConnect.dbWrite(pst);
               // dbConnect.dbClose();


        }catch(SQLException ex){
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
}


