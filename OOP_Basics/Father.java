package OOP_Basics;

public class Father {

    int property =1000;

    public String greet()
    {
        return "hello ";
    }



}

class son extends Father
{
    int salary=100;

}

class daughter extends Father
{
    int salary = 2000;
}
