public class Shopping {
    private  String cust_name,prod_name,prod_price,prod_author;

    public Shopping(String cust_name, String prod_name, String prod_price, String prod_author) {
        this.cust_name = cust_name;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.prod_author = prod_author;
    }

    public Shopping() {
        super();
    }

    public String getCust_name() {
        return cust_name;
    }

    public String getProd_name() {
        return prod_name;
    }

    public String getProd_price() {
        return prod_price;
    }

    public String getProd_author() {
        return prod_author;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }

    public void setProd_author(String prod_author) {
        this.prod_author = prod_author;
    }
}
