import javax.ejb.Local;
import java.util.ArrayList;
@Local
public interface ShoppingInterface {
    ArrayList<Shopping> viewShopping();
    boolean addCart(Shopping shopping);


}
