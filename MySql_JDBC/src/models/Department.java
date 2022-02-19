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
public class Department {
    private int id;
    private String name; 
    private int manager,location;

    public Department(int id, String name, int manager,int location ) {
        this.id = id;
        this.manager = manager;
        this.location = location;
        this.name = name;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", manager=" + manager + ", location=" + location + '}';
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
