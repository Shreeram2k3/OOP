package OOP_Basics;

public class Overriding {

    public static void main(String[] args) {

        Animal a = new Animal();
        a.hello();

        Human h = new Human();
        h.hello();

    }

}

class Animal
{
    public void hello()
    {
        System.out.println("hello from animal");
    }
}

class Human
{
    public void hello()
    {
        System.out.println("Hello from human");
    }
}
