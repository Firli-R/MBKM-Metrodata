/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DevidBa
 */
public class Region {
    private int regionId;
    private String regionName;
    private int count;

    public Region() {
    }

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", regionName=" + regionName + ", count=" + count + '}';
    }

    public Region(int regionId, String regionName,int count) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.count = count;
    }


    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }    

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}