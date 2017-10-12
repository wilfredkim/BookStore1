import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
@Stateless
@Local
public class AdminOperation implements  AdminInterface {
@EJB
DbConnectInterface dbConnect;

    public boolean authenticateAdmin(String email, String password) {

        //DbConnect dbConnect = new DbConnect();
        String sql = "SELECT * from admin  where Email='" + email + " ' and PassWord='" + password + "'";


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
