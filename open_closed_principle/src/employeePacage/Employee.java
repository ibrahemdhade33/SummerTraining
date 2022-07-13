package employeePacage;

public abstract class Employee {
    private int id ;
    private String Name ;

    public Employee(int id, String name) {
        this.id = id;
        Name = name;
    }

    public double calculateSalary(){return 0.0;}
}
