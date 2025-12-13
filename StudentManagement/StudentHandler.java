package StudentManagement;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentHandler {

    private Student std;
    private static int id;
    private ArrayList<Student> arr=new ArrayList<>();



    Scanner inp;
    StudentHandler(Scanner inp)
    {
        this.inp = inp;
    }

// Operation 1: starts here->  Getting Student details from Client
    public void enterStudentDetail()
    {
        System.out.println("Enter a Name:");
        String name = inp.nextLine();
        System.out.println("Enter a Department: ");
        String dep = inp.nextLine();
        System.out.println("Enter ROLL NO:");
        int roll = inp.nextInt();
        inp.nextLine();

        //    calling createStudent() to create an obj
        std= createStudent(name,dep,roll);

        //    calling addStudent() to add the created Student obj in list
        addStudent(std);
    }


    //    Creating an Object with the Student detail given by client
    public Student createStudent(String name, String dep, int roll)
    {
        return new Student(++id,name,dep,roll);
    }


    //    add the created Student obj in list
    public void addStudent(Student s)
    {
        arr.add(s);
        System.out.println("Added Successfully...");
    }

//    Operation 2: -> View All Students
    public void getAllStudentDetail()
    {

        if(arr.isEmpty())
        {
            System.out.println("----NO Students Found in DataBase----");
            System.out.println("Choose a Valid Operation");
        }
        else
        {
            System.out.println(" All Student Details:");
            for(Student i : arr)
            {
                System.out.println(i);
            }
        }

    }


 //  Operation 3-> Get one Student Details
    public void getOneStudentDetail()
    {
        System.out.println("Enter the Student id: ");
        int inpId = inp.nextInt();
        inp.nextLine();

        for(Student i : arr)
        {
            if(inpId== i.getId())
            {
                System.out.println(i);
                return;
            }

        }

        System.out.println("No Such Student Found ");
    }

//    Operation 4 -> Remove a student
    public void removeStudent()
    {
        if(arr.isEmpty())
        {
            System.out.println("The DataBase is Empty");
            return;
        }

        System.out.println("Enter the Student id You want to Remove:");
        int inpId= inp.nextInt();
        inp.nextLine();

        for (int i = 0; i <arr.size() ; i++) {

            if(inpId==arr.get(i).getId())
            {
                System.out.println(arr.get(i));
                arr.remove(arr.get(i));
                System.out.println("Student removed Succesfully");
                return;
            }

        }
        System.out.println("No Such Student Found");
    }

//    Operation 5 -> Update a Student details
    public void updateStudentDetails()
    {
        if(arr.isEmpty())
        {
            System.out.println("The DataBase is Empty");
            return;
        }

        System.out.println("Enter the Student id You want to Update:");
        int inpId= inp.nextInt();
        inp.nextLine();

        for (int i = 0; i <arr.size() ; i++) {

            if(inpId==arr.get(i).getId())
            {
                System.out.println(arr.get(i));
                while(true)
                {
                    System.out.println("Choose the data you want to update ?");
                    System.out.println("1. Name");
                    System.out.println("2. Department");
                    System.out.println("3. Roll Num");
                    System.out.println("4. All");
                    System.out.println("5. Exit Update Operation ");

                    String updateOption = inp.nextLine();


                    switch (updateOption)
                    {
                        case "1" ->updateName(arr.get(i));

                        case "2" -> updateDepartment(arr.get(i));
//
                        case "3" -> updateRollNum(arr.get(i));
//
                        case "4" -> updateAll(arr.get(i));

                        case "5" ->
                        {
                            System.out.println("Student record Successfully Updated");
                             return;
                        }

                        default -> System.out.println("Choose a valid option");
                    }
                }

            }

        }
        System.out.println("No Such Student Found");

    }

    public void updateName(Student i)
    {
        System.out.println("Old Name: "+ i.getName());
        System.out.println("Enter the New Name: ");

        String newName = inp.nextLine();

        i.setName(newName);

        System.out.println("Name updated");
        System.out.println(i);

    }

    public void updateDepartment(Student i)
    {
        System.out.println("Old Department: "+ i.getDep());
        System.out.println("Enter the New Department: ");

        String newDep = inp.nextLine();

        i.setDep(newDep);

        System.out.println("Department updated");
        System.out.println(i);

    }

    public void updateRollNum(Student i)
    {
        System.out.println("Old Roll Num: "+ i.getRoll());
        System.out.println("Enter the New Roll Num: ");

        int newRoll = inp.nextInt();
        inp.nextLine();

        i.setRoll(newRoll);

        System.out.println("Roll Num updated");
        System.out.println(i);

    }

    public void updateAll(Student i)
    {
        updateName(i);
        updateDepartment(i);
        updateRollNum(i);

    }



}
