package se.lexicon;

import se.lexicon.model.Bounty;
import se.lexicon.model.Marabou;
import se.lexicon.model.Product;
import se.lexicon.model.Snickers;
import se.lexicon.vendingMachine.IVendingMachine;
import se.lexicon.vendingMachine.VendingMachineImpl;

public class App {
    public static void main(String[] args) {
        // Creating chocolate objects
        Marabou marabou = new Marabou(1000, 20, "Marabou Fruit and nut");
        Bounty bounty = new Bounty(2000, 10, "Bounty coconut");
        Snickers snickers = new Snickers(3000, 25, "Snickers chocolate");


        Product[] Prod = {marabou, bounty, snickers};
        IVendingMachine vendingMachine = new VendingMachineImpl(Prod);


        // check available products
        Product[] availProduct = vendingMachine.getProducts();
        System.out.println("Available Products\n");
        for (Product availProd : availProduct)
            System.out.println(availProd);


        //deposit money  20 SEK

        vendingMachine.addCurrency(5);


        int balance = vendingMachine.getBalance();
        System.out.println("\nAvaliable balance is :" + balance);
        //Request product
        Product prod = vendingMachine.request(1000);
        if (prod != null)

            System.out.println("Requested Product:"+prod.getProductName() + " " + prod.getPrice());

        //String to =vendingMachine.getDescription(1000);
        //System.out.println("New: "+to);


        //End session
        int availbalance = vendingMachine.endSession();
        System.out.println("\nSession ended and Available balance:" + availbalance);


        //check balance
        int balance1 = vendingMachine.getBalance();
        System.out.println("\nAvaliable balance is :" + balance1);
    }

}
