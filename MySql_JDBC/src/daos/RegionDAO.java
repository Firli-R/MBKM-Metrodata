/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Region;

/**
 *
 * @author DevidBa
 */
public class RegionDAO {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION ";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
//                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setRegionId(resultSet.getInt(1));
//                region.setRegionName(resultSet.getString(2));
                regions.add(new Region(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    public boolean insert(Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REGION(id, name,count) VALUES(?,?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.setInt(3, region.getCount());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `region` WHERE `region`.`id` =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        return false;
        }
        
    }
    public Region getById(int id) {
        Region regions = new Region();
        String query = "SELECT * FROM REGION WHERE `region`.`id` =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 regions.setRegionId(resultSet.getInt(1));
                 regions.setRegionName(resultSet.getString(2));
                 regions.setCount(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }
    public boolean update(int id, Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE REGION SET name=?,count=? WHERE id=?");
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setInt(2, region.getCount());
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
