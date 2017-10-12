import javax.ejb.Local;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Local
public interface DbConnectInterface {

    boolean connect();
    boolean dbWrite(String sql);
    boolean dbWrite(PreparedStatement pst);
    PreparedStatement createprepareStatement(String sql);
    ResultSet dbRead(String sql);
    void dbClose();

}
