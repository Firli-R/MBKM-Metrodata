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
import models.Department;

/**
 *
 * @author Firli
 */
public class DepartmentDAO {
     private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Department> getAll(){
        List<Department> department = new ArrayList<>();
        String query = "SELECT * FROM `department`";
        try {
            ResultSet rs = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (rs.next()) {                
                Department departmentData = new Department(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4) );
                department.add(departmentData);
            }
        } catch (SQLException e) {
        }
        return department;
    }
    public boolean insert(Department department){
        String query = "INSERT INTO `department`(`id`, `name`, `manager`, `location`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, department.getId());
            ps.setString(2, department.getName());
            ps.setInt(3, department.getManager());
            ps.setInt(4, department.getLocation());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
    }
    public boolean update(int id,Department department){
        String query = "UPDATE `department` SET `name`=?,`manager`=?,`location`=? WHERE `id` = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, department.getName());
            ps.setInt(2, department.getManager());
            ps.setInt(3, department.getLocation());
            ps.setInt(4, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public Department getById(int id) {
        Department department = new Department();
        String query = "SELECT `id`, `name`, `manager`, `location` FROM `department` WHERE `id`=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 department.setId(resultSet.getInt(1));
                 department.setName(resultSet.getString(2));
                 department.setManager(resultSet.getInt(3));
                 department.setLocation(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
    public boolean delete(int id){
        String query = "DELETE FROM `department` WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
