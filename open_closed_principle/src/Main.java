import employeePacage.Employee;
import employeePacage.Manger;
import employeePacage.Senior;
import employeePacage.printSalaryRecord;

public class Main {
    public static void main(String[]args){
        Employee m  = new Manger(1,"ibraheem",10.4,25) ;
        Employee s = new Senior(2,"mohammed",9.4,27) ;
        printSalaryRecord p = new printSalaryRecord(m) ;
        p.print_salary();
        p = new printSalaryRecord(s) ;
        p.print_salary();
    }
}
