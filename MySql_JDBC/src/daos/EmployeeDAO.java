/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.Employee;

/**
 *
 * @author Firli
 */
public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> getAll() {
        List<Employee> employee = new ArrayList<>();
        String query = "SELECT `id`, `first_name`, `job`, `salary`, `manager`, `department`,`hire_date` FROM `employee`";
        try {
            ResultSet rs = connection.prepareStatement(query)
                    .executeQuery();
            while (rs.next()) {
                Employee employeeData = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                employee.add(employeeData);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employee;
    }

    public boolean insert(Employee employee) throws ParseException {
        String query = "INSERT INTO `employee`(`id`, `first_name`, `last_name`, `email`, `phone_number`, `hire_date`, `job`, `salary`, `comission_pct`, `manager`, `department`) VALUES (?,?,0,0,0,?,?,?,0,?,?)";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fd = formatter.parse(employee.getDate());
        java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
        try {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirst_name());
            ps.setDate(3, sqlDate);
            ps.setString(4, employee.getJob());
            ps.setFloat(5, employee.getSalary());
            ps.setInt(6, employee.getManager());
            ps.setInt(7, employee.getDepartment());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(int id, Employee employee) {
        String query = "UPDATE `employee` SET `first_name`=?,`hire_date`=?,`job`=?,`salary`=?,`manager`=?,`department`=? WHERE id=?";

        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fd = formatter.parse(employee.getDate());
            java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, employee.getFirst_name());
            ps.setDate(2, sqlDate);
            ps.setString(3, employee.getJob());
            ps.setFloat(4, employee.getSalary());
            ps.setInt(5, employee.getManager());
            ps.setInt(6, employee.getDepartment());
            ps.setInt(7, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Employee getById(int id) {
        String query = "SELECT `first_name`,`hire_date`,`job`,`salary`,`manager`,`department` FROM `employee` WHERE id=?";
        Employee employee = new Employee();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                employee.setFirst_name(rs.getString(1));
                employee.setDate(rs.getString(2));
                employee.setJob(rs.getString(3));
                employee.setSalary(rs.getFloat(4));
                employee.setManager(rs.getInt(5));
                employee.setDepartment(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employee;
    }
    public boolean delete(int id){
        String query ="DELETE FROM `employee` WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}
