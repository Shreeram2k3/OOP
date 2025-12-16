package ATM_MACHINE;

public class Main {
    public static void main(String[] args) {

        Customer cus1 = new Customer(1,"Shreeram",101,"1234",1000.0);

        System.out.println(cus1.header());
        System.out.println(cus1);
    }
}
