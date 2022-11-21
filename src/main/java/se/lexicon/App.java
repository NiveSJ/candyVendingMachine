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

        vendingMachine.addCurrency(100);


        int balance = vendingMachine.getBalance();
        System.out.println("\nAvaliable balance is :" + balance);
        //Request product
        int count = VendingMachineImpl.getCount();
        System.out.println(count);
        Product prod = vendingMachine.request(2000);
        if (prod != null)

            System.out.println("Requested Product:" + prod.getProductName() + " " + prod.getPrice());

        Product prod1 = vendingMachine.request(1000);
        if (prod1 != null)

            System.out.println("Requested Product:" + prod1.getProductName() + " " + prod1.getPrice());

        int balance1 = vendingMachine.getBalance();
        System.out.println("\nAvaliable balance is :" + balance1);
        Product prod2 = vendingMachine.request(3000);
        if (prod2 != null)

            System.out.println("Requested Product:" + prod2.getProductName() + " " + prod2.getPrice());

        int balance2 = vendingMachine.getBalance();
        System.out.println("\nAvaliable balance is :" + balance2);

        Product prod3 = vendingMachine.request(3000);
        if (prod3 != null)

            System.out.println("Requested Product:" + prod3.getProductName() + " " + prod2.getPrice());

        //String to =vendingMachine.getDescription(1000);
        //System.out.println("New: "+to);


        //End session
        int availbalance = vendingMachine.endSession();
        System.out.println("\nSession ended and Available balance:" + availbalance);


        //check balance
        int balance5 = vendingMachine.getBalance();
        System.out.println("\nAvaliable balance is :" + balance5);
    }

}
