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
import models.Job;

/**
 *
 * @author Firli
 */
public class JobDAO {
    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Job> getAll(){
        String query = "SELECT * FROM job";
        List<Job> job = new ArrayList<>();
        try {
            ResultSet rs = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (rs.next()) {                
                Job jodData = new Job(rs.getString(1), rs.getString(2), rs.getFloat(3),rs.getFloat(4));
                job.add(jodData);
            }
        } catch (Exception e) {
        }
        return job;
    }
    public boolean insert(Job job){
        String query = "INSERT INTO `job`(`id`, `title`, `min_salary`, `max_salary`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, job.getId().toUpperCase());
            ps.setString(2, job.getTitle());
            ps.setFloat(3, job.getMin_salary());
            ps.setFloat(4, job.getMax_salary());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
     public boolean update(String id,Job job){
        String query = "UPDATE `job` SET `title`=?,`min_salary`=?,`max_salary`=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, job.getTitle());
            ps.setFloat(2, job.getMin_salary());
            ps.setFloat(3, job.getMax_salary());
            ps.setString(4, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
       
    }
    public Job getById(String id){
        String query = "SELECT * FROM job where id=?";
        Job job = new Job();
        try {
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                job.setId(rs.getString(1));
                job.setTitle(rs.getString(2));
                job.setMin_salary(rs.getFloat(3));
                job.setMax_salary(rs.getFloat(4));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return job;
    }
    public boolean delete(String id){
        String query ="DELETE FROM `job` WHERE id = ?";
        try {
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return true;
        }
    }
}
