/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Firli
 */
public class Employee {
    private int id;
    private String first_name;
    private String job;
    private float salary;
    private int manager;
    private int department;
    private String date;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", first_name=" + first_name + ", job=" + job + ", salary=" + salary + ", manager=" + manager + ", department=" + department + ", date=" + date + '}';
    }

    public Employee(int id, String first_name, String job, float salary, int manager, int department,String date) {
        this.id = id;
        this.first_name = first_name;
        this.job = job;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
    
}
