package se.lexicon;


import org.junit.Test;
import org.junit.Assert;
import se.lexicon.model.Bounty;
import se.lexicon.model.Marabou;
import se.lexicon.model.Snickers;
import se.lexicon.vendingMachine.VendingMachineImpl;
import se.lexicon.model.Product;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    Marabou marabou = new Marabou(1000, 20, "Marabou Fruit and nut");
    Bounty bounty = new Bounty(2000, 10, "Bounty coconut");
    Snickers snickers = new Snickers(3000, 25, "Snickers chocolate");
    Product[] prod={bounty};


    @Test

    public void candyVendingmachine(){


        VendingMachineImpl vmi= new VendingMachineImpl(prod);
        // Add product

       // String[] str=vmi.getProducts();
         // Check whether it is correctly added
       // for(String stri:str )
        //Assert.assertEquals(bounty,stri.toString());
           // Check currency add
        vmi.addCurrency(200);
        Assert.assertEquals(vmi.depositPool,200);

         // Check Requested product returned correctly
        Product prod = vmi.request(2000);
        Assert.assertEquals(bounty,prod);

        // Check balance

        int balance = vmi.getBalance();
        Assert.assertEquals(190,balance);

        int availbalance= vmi.endSession();
        Assert.assertEquals(190,availbalance);







    }

}
