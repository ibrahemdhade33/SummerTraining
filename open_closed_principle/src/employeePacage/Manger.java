package employeePacage;

public class Manger extends Employee {
    private double hourlyRate;
    private int DayWorks ;

    public Manger(int id, String name, Double hourlyRate, int dayWorks) {
        super(id,name);
        this.hourlyRate = hourlyRate;
        DayWorks = dayWorks;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate*DayWorks *1.3 ;
    }
    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getDayWorks() {
        return DayWorks;
    }

    public void setDayWorks(int dayWorks) {
        DayWorks = dayWorks;
    }
}
