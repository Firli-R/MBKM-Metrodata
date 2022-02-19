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
public class Job {
    private String id,title;
    private float min_salary,max_salary;

    public Job(String id, String title, float min_salary, float max_salary) {
        this.id = id;
        this.title = title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public Job() {
    }
    
    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", title=" + title + ", min_salary=" + min_salary + ", max_salary=" + max_salary + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(float min_salary) {
        this.min_salary = min_salary;
    }

    public float getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(float max_salary) {
        this.max_salary = max_salary;
    }
    
}
