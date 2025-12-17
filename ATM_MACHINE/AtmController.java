package ATM_MACHINE;

import java.util.Scanner;

public class AtmController {


    private int hundredsCount;
    private int fiveHundredsCount;
    private int thousandsCount;

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

        setAtmCashCount(cash);
    }

    public void setAtmCashCount(int cash)
    {
        //denominations
        hundredsCount += 300*cash;
        fiveHundredsCount += 100*cash;
        thousandsCount += 20*cash;

        System.out.println(".........CASH LOADING.........\n"+"NOTES COUNT: \n"+
                            getHundredsCount()+" * 100 Rupees,\n"+
                           getFiveHundredsCount()+" * 500 Rupees,\n"+
                            getThousandsCount()+" * 100 Rupees,\n"+"------------------------------------"+"\n"+
                            "TOTAL = Rs. "+getAtmBalance()+" "+" Available in ATM"
        );

    }

    public double getAtmBalance() {
        return (hundredsCount *100)+(fiveHundredsCount *500)+(thousandsCount *1000);
    }

    public int getHundredsCount() {
        return hundredsCount;
    }

    public int getFiveHundredsCount() {
        return fiveHundredsCount;
    }

    public int getThousandsCount() {
        return thousandsCount;
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
                case "4" -> cust.miniStatement(i);

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
