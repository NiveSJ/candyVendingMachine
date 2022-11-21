package se.lexicon.vendingMachine;

import se.lexicon.model.Product;

import java.util.Arrays;


public class VendingMachineImpl implements IVendingMachine {

    private Product[] products;

    public int depositPool;

    private static int count;

    private VendingMachineImpl() {
    }

    private static VendingMachineImpl vendingMachine;

    public static VendingMachineImpl getInstance() {
        if (vendingMachine == null) vendingMachine = new VendingMachineImpl();
        return vendingMachine;

    }

    public static int getCount() {
        return count;
    }


    public VendingMachineImpl(Product[] products) {
        setProducts(products);
        this.depositPool = 0;

    }


    public void setProducts(Product[] products) {  // new Implementation
        VendingMachineImpl.count = products.length;

        this.products = products;
    }

    public int getDepositPool() {
        return depositPool;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }


    public void addCurrency(int amount) {
        int valid_cur[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        int retur = Arrays.binarySearch(valid_cur, amount);
        if (retur >= 0)
            this.depositPool += amount;

        else System.out.println("Please Deposit valid Currency");


    }

    public int getBalance() {

        return this.depositPool;
    }

    public Product request(int id) {


        for (Product prod : products) {

            if (VendingMachineImpl.count == 0) throw new RuntimeException("Vending machine is out of stock");

            if (id == prod.getId()) {
                if (!prod.isAvailable()) throw new RuntimeException("Requested product not available");
                if (depositPool >= prod.getPrice() && VendingMachineImpl.count != 0) {
                    this.depositPool -= (int) prod.getPrice();
                    VendingMachineImpl.count--;
                    prod.setAvailable(false);

                    return prod;
                }

            }


        }
        return null;
    }

    public int endSession() {
        int tmp = this.depositPool;
        this.depositPool = 0;
        return tmp;
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

       /* String[] str = new String[products.length];
        int i=0;
        for (Product prod : products) {

            str[i]=prod.toString();
            i++;
        }*/
        Product[] newprod = Arrays.copyOf(products, products.length);
        return newprod;
    }
}
