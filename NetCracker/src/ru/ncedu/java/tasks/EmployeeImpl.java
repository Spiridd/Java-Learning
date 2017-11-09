package ru.ncedu.java.tasks;

/**
 * Created by dimon on 18.08.17.
 */
public class EmployeeImpl implements Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private Employee manager;

    public EmployeeImpl() {
        this.firstName = null;
        this.lastName = null;
        this.salary = 1000;
        manager = null;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void increaseSalary(int value) {
        this.salary += value;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        return this.manager != null ? this.manager.getFullName() : "No manager";
    }

    @Override
    public Employee getTopManager() {
        return this.getManagerName() == "No manager" ? this : this.manager.getTopManager();
    }
}
