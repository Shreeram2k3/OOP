package OOP_Basics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Student std1 = new Student(107,"Shreeram",95.5);

        std1.setPass("1234");

        Scanner inp = new Scanner(System.in);

        System.out.println(std1.getPass());
        String upass =inp.next();

        if(upass.equals(std1.getPass()))
        {
            System.out.println("welcome user");
        }
        else
        {
            System.out.println("unauthorized");
        }






    }
}
