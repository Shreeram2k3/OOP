package StudentManagement;


import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        Scanner inp=new Scanner(System.in);

        StudentHandler operations = new StudentHandler(inp);
       while(true)
        {
            System.out.println("------------Student Management System------------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Get one Student Details");
            System.out.println("4. Remove a Student");
            System.out.println("5. Exit");
            System.out.println("Enter an Option: ");


            String option = inp.next();
            inp.nextLine();

            switch (option)
            {
                case "1" -> operations.enterStudentDetail();

                case "2" -> operations.getAllStudentDetail();

                case "3" -> operations.getOneStudentDetail();

                case "4"-> operations.removeStudent();

                case "5" -> {
                    System.out.println("-----------------------Thank You!----------------------------");
                return;
                }

                default -> System.out.println("Choose a Valid Operation");


            }


        }







    }



}
