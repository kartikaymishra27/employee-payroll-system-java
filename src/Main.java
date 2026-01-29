import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    public void removeEmployee(int id) {
        Employee remove = null;
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                remove = e;
                break;
            }
        }
        if (remove != null) {
            employeeList.remove(remove);
        }
    }

    public void displayEmployee() {
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    public int remainingTotal() {
        return employeeList.size();
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Rahul", 101, 50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Amit", 102, 80, 300);

        ps.addEmployee(emp1);
        ps.addEmployee(emp2);

        System.out.println("Initial Employees:");
        ps.displayEmployee();

        ps.removeEmployee(101);

        System.out.println("After Removing:");
        ps.displayEmployee();

        System.out.println("Remaining Total: " + ps.remainingTotal());
    }
}
                                                                                  