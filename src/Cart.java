import java.sql.Date;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Cart {
    private Product[] products;
    private double total;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        date=new Date(GregorianCalendar.DATE);
        this.date = date;
    }


    public Cart(Product[] products) {
        this.products =new Product[0];
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public void addProductToCart(Product product){
        products=new Product[products.length+1];
        products[products.length-1]=product;
    }
    public void removeProductFromCart(int n){
        for (int i=n; i< products.length-1; i++){
            products[i]=products[i+1];
        }
        products=new Product[products.length-1];
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        for (int i=0; i<getProducts().length; i++){
            total= getProducts()[i].getPrice()+total;
        }
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart:{" +
                "products= " + Arrays.toString(products) + '\n'+
                ", total= " + total + '\n'+ "date= " + date + '\n' +'}';
    }
}
