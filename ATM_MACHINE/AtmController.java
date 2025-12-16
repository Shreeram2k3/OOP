package ATM_MACHINE;

import java.util.Scanner;

public class AtmController {

    private double atmBalance;
    private CustomerController cust;
    Scanner inp;
    AtmController(Scanner inp,CustomerController cust)
    {
        this.inp = inp;
        this.cust = cust;
    }

    public void loadCash()
    {
        System.out.println("Enter the amount you want to Load: ");
        int cash = inp.nextInt();
        inp.nextLine();

        setAtmBance(cash);
    }

    public void setAtmBance(int cash)
    {
        atmBalance = 100000*cash;
    }

    public void viewOperations()
    {
         Customer authUser = cust.auth();
        if(authUser!=null)
        {
            System.out.println("welcome user ");
            atmMenu(authUser);
        }
        else
        {
            System.out.println("Invalid Credentials");
        }
    }

    public void atmMenu(Customer i)
    {
        while(true)
        {
            System.out.println("-------ATM Operations-------");
            System.out.println("1. Check Balance");
            System.out.println("2. WithDraw Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            System.out.println("Enter a Operation: ");
            String option = inp.nextLine();

            switch (option)
            {
                case "1" -> cust.checkBalance(i);

//                case "2" -> cust.withdrawMoney();
//
//                case "3" -> cust.transferMoney();
//
//                case "4" -> cust.transferMoney();

                case "5" ->{
                    System.out.println("--------Thank you for Banking with us !--------");
                    System.out.println("....................Exiting..........................");
                    return;
                }



            }
        }
    }
//    public void viewAtmBalance()
//    {
//        System.out.println("ATM BALANCE: "+atmBalance);
//    }

}
