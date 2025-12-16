package ATM_MACHINE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        CustomerController cusCon = new CustomerController(inp);
        AtmController atmCon = new AtmController(inp,cusCon);

        while(true)
        {
            System.out.println("----------ATM MACHINE----------");

            System.out.println("1. Load Cash");
            System.out.println("2. Show Customers");
            System.out.println("3. View Operations");

            System.out.println("Enter an Option: ");
            String option = inp.nextLine();

            switch (option)
            {
                case "1" -> atmCon.loadCash();

                case "2" -> cusCon.viewAllCustomers();

                case "3" -> atmCon.viewOperations();

                default -> {
                    return;
                }
            }

        }



    }
}
