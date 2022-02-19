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
public class Location {
    private int id;
    private String address;
    private String countryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Location(int id, String address, String countryId) {
        this.id = id;
        this.address = address;
        this.countryId = countryId;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", address=" + address + ", countryId=" + countryId + '}';
    }
    
}
