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
import models.Location;


/**
 *
 * @author Firli
 */
public class LocationDAO {
     private Connection connection;
    public LocationDAO(Connection connection) {
        this.connection = connection;
    }
   
    
    public List<Location> getAll(){
        List<Location> location = new ArrayList<>();
        String query = "SELECT `id`, `street_address`, `country` FROM location";
        try {
            ResultSet rs = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (rs.next()) {                
                Location locationData = new Location(rs.getInt(1), rs.getString(2), rs.getString(3));
                location.add(locationData);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return location;
    }
    public boolean insert(Location location){
        String query = "INSERT INTO `location`(`id`,`street_address`,`postal_code`, `city`, `state_province`, `country`) VALUES (?,?,0,0,0,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, location.getId());
            ps.setString(2, location.getAddress());
            ps.setString(3, location.getCountryId().toUpperCase());
            ps.execute();
        return true;
        } catch (SQLException e) {
            System.out.println(e);
        return false;
        }
    }
    public boolean update(int id,Location location){
        String query = "UPDATE `location` SET `street_address`=?,`country`=? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, location.getAddress());
            ps.setString(2, location.getCountryId().toUpperCase());
            ps.setInt(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean delete(int id){
        String query = "DELETE FROM `location` WHERE id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }
     public Location getById(int id) {
        Location location = new Location();
        String query = "SELECT `id`, `street_address`, `country` FROM Location WHERE `Location`.`id` =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 location.setId(resultSet.getInt(1));
                 location.setAddress(resultSet.getString(2));
                 location.setCountryId(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }
}
