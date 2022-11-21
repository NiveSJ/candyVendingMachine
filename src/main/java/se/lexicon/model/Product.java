package se.lexicon.model;

public abstract class Product {

    private int id;
    private double price;
    private String productName;

    private boolean available;


    public Product(int id, double price, String productName) {
        this.id = id;
        this.price = price;
        this.productName = productName;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public abstract String examine();

    public abstract String use();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }
}
