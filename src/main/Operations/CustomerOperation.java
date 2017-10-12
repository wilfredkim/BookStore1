import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;

@Stateless
@Local
public class CustomerOperation implements CustomerInterface {
    @EJB
    DbConnectInterface dbConnect;

    public boolean register(Customer customer) {

        //DbConnect dbConnect = new DbConnect();
        String sql = "INSERT into customer(Name,Email,PassWord) values(?,?,?)";
        PreparedStatement pst = dbConnect.createprepareStatement(sql);

        try {
            pst.setString(1, customer.getCustomer_name());
            pst.setString(2, customer.getCustomer_email());
            pst.setString(3, customer.getCustomer_password());
            dbConnect.dbWrite(pst);
            //dbConnect.dbClose();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean authenticateCustomer(String email, String password) {
       // DbConnect dbConnect = new DbConnect();
        String sql = "SELECT * from customer  where Email='" + email + " ' and PassWord='" + password + "'";


        try {
            ResultSet rs = dbConnect.dbRead(sql);
            while (rs != null && rs.next()) {

                return true;
            }
            //dbConnect.dbClose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;

    }

}
