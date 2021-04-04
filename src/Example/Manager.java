package Example;

public class Manager extends Employee {

    public double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return bonus + super.getSalary();
    }


}
