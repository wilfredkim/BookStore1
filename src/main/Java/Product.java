public class Product {
    private String product_name;
    private String product_price;
    private String product_author;
    //constructor


    public Product(String product_name, String product_price, String product_author) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_author = product_author;
    }
//empty constructor
    public Product() {
        super();
    }

    //product getters
    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public String getProduct_author() {
        return product_author;
    }

    // product setters
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public void setProduct_author(String product_author) {
        this.product_author = product_author;
    }
}
