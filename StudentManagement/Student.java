package StudentManagement;

public class Student {

    private  int id;
    private String name;
    private String dep;
    private int roll;


    public Student(int id, String name, String dep, int roll) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.roll = roll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "----------------------"+"\n"+
                "Student "+ id + " Details: "+"\n"+
                "Name : " + name + "\n" +
                "Department: " + dep + "\n" +
                "Roll Num: " + roll+"\n"+
                "----------------------"+"\n"
                ;
    }
}
