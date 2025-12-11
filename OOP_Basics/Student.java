package OOP_Basics;

public class Student {
    int roll;
    String name;
    double mark;
    private String pass;



    Student(int roll, String name, double mark)
    {
       this.roll = roll;
        this.name = name;
        this.mark = mark;

    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return pass;
    }

    public  String greet()
    {
        return "WElcome back,"+this.name+"👋";
    }





    @Override
    public String toString() {
        return "OOP_Basics.Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", mark=" + mark +

                '}';
    }
}
