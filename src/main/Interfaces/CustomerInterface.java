import javax.ejb.Local;

@Local
public interface CustomerInterface {

    boolean register(Customer customer) ;
    boolean authenticateCustomer(String email, String password);

}
