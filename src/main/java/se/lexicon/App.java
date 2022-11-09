package se.lexicon;

import se.lexicon.model.Bounty;
import se.lexicon.model.Marabou;
import se.lexicon.model.Product;
import se.lexicon.model.Snickers;
import se.lexicon.vendingMachine.VendingMachineImpl;

import java.sql.SQLOutput;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
         // Creating chocolate objects
        Marabou marabou = new Marabou(1000, 20, "Marabou Fruit and nut");
        Bounty bounty = new Bounty(2000, 10, "Bounty coconut");
        Snickers snickers = new Snickers(3000, 25, "Snickers chocolate");



        VendingMachineImpl vendingMachineImpl = new VendingMachineImpl();
        // Adding to Vending machine
        vendingMachineImpl.addToVendingMachine(marabou);
        vendingMachineImpl.addToVendingMachine(bounty);
        vendingMachineImpl.addToVendingMachine(snickers);

        // check available products
       Product[] availProduct= vendingMachineImpl.getProducts();
        System.out.println("Available Products\n");
       for(Product availProd:availProduct )
           System.out.println(availProd);

        //deposit money
        vendingMachineImpl.addCurrency(20);

        //Request product
        Product prod = vendingMachineImpl.request(1000);
        if (prod == null) {
            System.out.println("Product not available");
        } else {
            System.out.println("\nRequested Product available");
            System.out.println(vendingMachineImpl.getDescription(prod.getId()));
        }
        //check balance
        int balance = vendingMachineImpl.getBalance();
        System.out.println("\nAvaliable balance is :" + balance);
        //End session
        int availbalance= vendingMachineImpl.endSession();
        System.out.println("\nSession ended and Available balance:"+ availbalance);




    }

}
