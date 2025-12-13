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


//Operation 3-> Get one Student Details
    public void getOneStudentDetail()
    {
        System.out.println("Enter the Student id: ");
        int inpId = inp.nextInt();

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

    public void removeStudent()
    {
        System.out.println("Enter the Student id You want to Remove:");
        int inpId= inp.nextInt();

        for(Student i: arr)
        {
            if(inpId==i.getId())
            {
                System.out.println(i);
                arr.remove(i);
                System.out.println("Student removed Succesfully");
                return;
            }
        }
        System.out.println("No Such Student Found");
    }



}
