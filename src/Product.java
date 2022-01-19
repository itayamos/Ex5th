public class Product {
    private double price;
    private String productName;
    private boolean available;
    private User user;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (user.getMembership()){
            this.discount=discount;
        }
        else {
            this.discount=0;
        }
    }

    private double discount;

    public Product(double price, String productName, boolean available, double discount) {
        this.price = price;
        this.productName = productName;
        this.available=available;
        this.discount=discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' + "available="+available+
                '}';
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
