package se.lexicon.vendingMachine;

import se.lexicon.model.Product;

import java.util.Arrays;


public class VendingMachineImpl implements IVendingMachine {

    private Product[] products = new Product[0];

    public int depositPool;
    public int sessionEndBal;

    public VendingMachineImpl() {
        this.depositPool = 0;
        this.sessionEndBal = 0;
    }


    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getDepositPool() {
        return depositPool;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }

    public void addToVendingMachine(Product product) {
        Product[] add = Arrays.copyOf(products, products.length + 1);
        add[add.length - 1] = product;
        products = add;
        this.products = products;
    }


    public void addCurrency(int amount) {
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10 || amount == 20 || amount == 50 || amount == 100 || amount == 200 || amount == 500 || amount == 1000)

            this.depositPool += amount;

        else System.out.println("Please Deposit valid Currency");


    }

    public int getBalance() {

        return this.depositPool;
    }

    public Product request(int id) {


        for (Product prod : products) {
            if (depositPool >= prod.getPrice()) {
                if (id == prod.getId()) this.depositPool -= prod.getPrice();
                return prod;
            }
        }


        return null;
    }

    public int endSession() {
        this.sessionEndBal = this.depositPool;
        this.depositPool = 0;
        return sessionEndBal;
    }

    public String getDescription(int id) {

        for (Product prod : products) {
            if (prod.getId() == id) {

                return prod.toString();
            }

        }
        return "No maching product found";


    }

    public Product[] getProducts() {

        return products;
    }
}
