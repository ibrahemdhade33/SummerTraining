package employeePacage;

public class Senior extends Employee{
    private double hourlyRate ;
    private int workDays ;

    public Senior(int id, String name, double hourlyRate, int workDays) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.workDays = workDays;
    }
    @Override
    public double calculateSalary(){
        return this.hourlyRate*this.workDays *1.1;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }
}
