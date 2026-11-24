package Entities;

public class Employee {
    private int employee_id;
    private String employee_name;
    private double salary;
    private int supervisor_id;
    
    public Employee(){
        super();
    }
    public Employee(int employee_id, String employee_name, double salary, int supervisor_id){
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.salary = salary;
        this.supervisor_id = supervisor_id;
    }
    public int getEmployee_id() {
        return employee_id;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public double getSalary() {
        return salary;
    }
    public int getSupervisor_id() {
        return supervisor_id;
    }
    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", salary=" + salary
                + ", supervisor_id=" + supervisor_id + "]";
    }
    
}
