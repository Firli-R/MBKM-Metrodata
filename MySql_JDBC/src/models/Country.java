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
public class Country {
    private String id;
    private String name;
    private int regionId;

    public Country(String id, String name, int regionId) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
    }

    public Country() {
    }
    

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", regionId=" + regionId + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    
}
