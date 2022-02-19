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
import models.Country;

/**
 *
 * @author Firli
 */
public class CountryDAO {
    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Country> getAll(){
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM `country`";
        try {
            ResultSet rs = connection
                    .prepareStatement(query)
                    .executeQuery();
            while(rs.next()) {                
                Country country = new Country(rs.getString(1),rs.getString(2),rs.getInt(3));
                countries.add(country);
            }
        }catch(SQLException e) {
            e.printStackTrace();;
        }
        return countries;
    }
    
    public boolean insert(Country country){
        String query = "INSERT INTO `country`(id, name,region) VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getId().toUpperCase());
            ps.setString(2, country.getName().toUpperCase());
            ps.setInt(3, country.getRegionId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("error terjadi: "+e);
            return false;
        }
    }
    public boolean update(String id,Country country){
        String query = "UPDATE `country` SET `name`=?,`region`=? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
             ps.setString(1, country.getName().toUpperCase());
             ps.setInt(2, country.getRegionId());
             ps.setString(3, id.toUpperCase());
             ps.executeUpdate();
            return true;
        } catch (SQLException e) {
             System.out.println("error terjadi: "+e);
            return false;
        }
    }
    public boolean delete(String id){
    String query = "DELETE FROM `country` WHERE `id` =?";
    try {
            PreparedStatement ps = connection.prepareStatement(query);
             ps.setString(1, id);
             ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println("error terjadi: "+e);
        }
    return true;
    }
    public Country getById(String id) {
        Country country = new Country();
        String query = "SELECT * FROM country WHERE `country`.`id` =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 country.setId(resultSet.getString(1));
                 country.setName(resultSet.getString(2));
                 country.setRegionId(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }
   
}
