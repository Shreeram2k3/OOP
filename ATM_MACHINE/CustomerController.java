package ATM_MACHINE;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController {

    private Scanner inp;
    private int id;
    private long accNo =100;
    private Customer cust;

    List<Customer> customerList = new ArrayList<>();

    CustomerController(Scanner inp)
    {
        this.inp = inp;
    }

    public void viewAllCustomers()
    {
        if(customerList.isEmpty())
        {
            System.out.println("No Customer Found");

            System.out.println("Do you Want to Add a New Customer ? (Y/N)");
            String choice =inp.nextLine();
            if(choice.equals("Y")||choice.equals("y"))
            {
                addNewCustomer();
            }
        }
        else {
            displayAllCustomers();
            System.out.println("Do you Want to Add a New Customer ? (Y/N)");
            String choice =inp.nextLine();
            if(choice.equals("Y")||choice.equals("y"))
            {
                addNewCustomer();
            }

        }
    }

    public void addNewCustomer()
    {
        System.out.println(" Enter Customer Name: ");
        String name = inp.nextLine();

        System.out.println("Enter the PIN Number: ");
        String pin = inp.nextLine();

        System.out.println("Enter the Balance: ");
        double balance = inp.nextDouble();
        inp.nextLine();

        cust = createCustomer(name,pin,balance);

        addCustomerList(cust);


    }

    public Customer createCustomer(String name,String pin, double balance)
    {
        return new Customer(++id,name,++accNo,pin,balance);
    }

    public void addCustomerList(Customer i)
    {
        customerList.add(i);
        printHeader();
        System.out.println(i);
        System.out.println("Customer added succesfully");

    }



    public void displayAllCustomers()
    {
        printHeader();

        for(Customer i : customerList)
        {
            System.out.println(i);
        }
    }

    public static void printHeader() {
        System.out.printf(
                "| %-12s | %-15s | %-12s | %-10s | %-10s |%n",
                "Customer ID", "Customer Name", "Acc No.", "PIN", "Balance"
        );
    }

// Customer side ATM Operations

//    Authenticator
    public Customer auth()
    {
        System.out.println("Enter Acc No: ");
        long acc = inp.nextLong();
        inp.nextLine();

        System.out.println("Enter PIN : ");
        String uPin =inp.nextLine();

        return authenticate(acc,uPin);
    }
//validating credentials
    public Customer authenticate(long accNo,String pin)
    {
        // finduser
        for(Customer i : customerList)
        {
            if(i.getAccNumber()==accNo && i.getPin().equals(pin ))
            {
                return i;
            }
        }
        return null;
    }

    public void checkBalance(Customer i)
    {
        System.out.println("BALANCE: "+i.getBalance());
    }

}
