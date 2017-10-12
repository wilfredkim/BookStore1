import javax.ejb.Local;
import java.util.ArrayList;
@Local
public interface ProductInterface {

    boolean addProduct(Product produt);
    ArrayList<Product> viewProduct();
    Product selectByName(String name);

}
