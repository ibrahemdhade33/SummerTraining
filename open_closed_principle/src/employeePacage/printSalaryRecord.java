package employeePacage;

public class printSalaryRecord {
    Employee employee ;

    public printSalaryRecord(Employee employee) {
        this.employee = employee;
    }
    public void print_salary(){

        System.out.println(employee.calculateSalary());
    }
}
