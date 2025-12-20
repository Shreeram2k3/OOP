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

                case "2" -> withdrawMoney(i);
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

//2. WithdrawMoney


    public void withdrawMoney(Customer i)
    {
        //  should be *100 <=10,000
        System.out.println("Enter the amount you want to Withdraw:");
        int withAmount = inp.nextInt();
        inp.nextLine();

        if(isValidWithdrawal(i,withAmount))
        {
            //calculate Notes to dispence
            calculateNotes(withAmount,i);

        }


    }

    public boolean isValidWithdrawal(Customer i, int withAmount)
    {
        if(withAmount%100==0 && withAmount<=10000)
        {
            if(withAmount<= i.getBalance() )
            {
                if(withAmount<=getAtmBalance())
                {
                    return true;
                }
                else {
                    System.out.println("InSufficient CASH in ATM");
                    return false;
                }
            }

            else
            {
                System.out.println("InSufficient Balance in Your Account");
                return false;
            }
        }
        else {
            System.out.println("Enter a Valid Amount to Withdraw");
        }

        return false;
    }

    public void calculateNotes(int reqAmount,Customer i)
    {
        if(reqAmount>=5000)
        {
            calculateRule1(reqAmount,i);
        }
        else
        {
            calulateRule2(reqAmount,i);
        }
    }
    public void calculateRule1(int reqAmount,Customer i)
    {
          int usedThousands;
         int usedFiveHundreds;
         int usedHundreds;
        // max one 1000

        usedThousands =Math.min(1,thousandsCount);
        reqAmount-= usedThousands*1000;

        // use as many 500s
        usedFiveHundreds =Math.min(reqAmount/500,fiveHundredsCount);
        reqAmount-= usedFiveHundreds*500;

        //max ten hundreds;
        usedHundreds = Math.min(reqAmount/100,10);
        usedHundreds =Math.min(usedHundreds,hundredsCount);
        reqAmount -= usedHundreds*100;

        if (reqAmount != 0) {
            System.out.println("Cannot dispense required denominations");
            return;
        }


        dispenseMoney(usedHundreds,usedFiveHundreds,usedThousands,i);

    }

    public void calulateRule2(int reqAmount,Customer i)
    {
        int usedThousands;
        int usedFiveHundreds;
        int usedHundreds;
        // max 0 1000

        usedThousands =0;

        // max 8 500s
        usedFiveHundreds = Math.min(reqAmount / 500, 8);
        usedFiveHundreds = Math.min(usedFiveHundreds, fiveHundredsCount);

        reqAmount-= usedFiveHundreds*500;

        //rest hundreds;
        usedHundreds = Math.min(reqAmount/100,hundredsCount);

        reqAmount -= usedHundreds*100;

        if (reqAmount != 0) {
            System.out.println("Cannot dispense required denominations");
            return;
        }


        dispenseMoney(usedHundreds,usedFiveHundreds,usedThousands,i);
    }

    public void dispenseMoney(int usedHundreds, int usedFiveHundreds, int usedThousands, Customer i)
    {
        thousandsCount-=usedThousands;
        fiveHundredsCount-=usedFiveHundreds;
        hundredsCount-=usedHundreds;

        int amount =1000*usedThousands+500*usedFiveHundreds+100*usedHundreds;
        i.setBalance(i.getBalance()-amount);

        System.out.println("Withdrawing.......: ");
        System.out.println("100 * "+usedHundreds);
        System.out.println("500 * "+usedFiveHundreds);
        System.out.println("1000 * "+usedThousands);
        System.out.println("Dispensed Amount: " + amount);

        Transaction t = new Transaction(
                /* id */ i.getTransactions().size() + 1,
                "Withdraw from ATM",
                "Debit",
                amount
        );

        i.addTransaction(t);





    }




}
