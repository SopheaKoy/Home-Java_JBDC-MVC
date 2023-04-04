package co.phea.dao;

import co.phea.connectionDB.JdbcImp;
import co.phea.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeImp implements EmployeeDao {
    Scanner scanner = new Scanner(System.in);
    JdbcImp jdbc = new JdbcImp();

    @Override
    public void insertSql(Employee employee) {
        try(Connection con = jdbc.dataSource().getConnection()){
            String insertSql = "INSERT INTO employee (name,gender,dob,phone)"+"VALUES (?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(insertSql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getGender());
            statement.setString(3,employee.getDob());
            statement.setInt(4, employee.getPhone());
            int insert= statement.executeUpdate();
            System.out.println(insert);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void updateSql() {
        Employee employee = new Employee();
        System.out.println("Enter ID to update : ");
        int UID = scanner.nextInt();
        try(Connection con=jdbc.dataSource().getConnection()){
            String updateById = "UPDATE employee SET name = ? , gender = ? , dob = ? , phone = ?" +
                    "WHERE id = ? ";
            PreparedStatement statement =con.prepareStatement(updateById);
            statement.setString(1,employee.getName());
            statement.setString(2,employee.getGender());
            statement.setString(3,employee.getDob());
            statement.setInt(4,employee.getPhone());
            int updateId = statement.executeUpdate();
            System.out.println("Update record successfully.");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteSql() {
        System.out.print("Enter id of employee to delete : ");
        int DID = scanner.nextInt();
        try(Connection con = jdbc.dataSource().getConnection()){
            String deleteByID = "DELETE FROM employee WHERE id = ?";
            PreparedStatement statement = con.prepareCall(deleteByID);
            statement.setInt(1,DID);
            int resultSet = statement.executeUpdate();
            System.out.println(resultSet);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void selectById() {
        System.out.print("Enter ID to select : ");
        int SID = scanner.nextInt();
        try(Connection con = jdbc.dataSource().getConnection()){
            String selectById = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement statement = con.prepareCall(selectById);
            statement.setInt(1,SID);
            ResultSet resultSet = statement.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender =resultSet.getString("gender");
                String dob = resultSet.getString("dob");
                Integer phone = resultSet.getInt("phone");
                list.add(new Employee(id,name,gender,dob,phone));
            }
            list.stream().forEach(System.out::println);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void selectSql() {
        try(Connection con =jdbc.dataSource().getConnection()){
            String selectUrl = "SELECT * FROM employee";
            PreparedStatement statement = con.prepareStatement(selectUrl);
            ResultSet resultSet = statement.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender =resultSet.getString("gender");
                String dob = resultSet.getString("dob");
                Integer phone = resultSet.getInt("phone");
                list.add(new Employee(id,name,gender,dob,phone));
            }
            list.stream().forEach(System.out::println);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void selectName() {
        System.out.print("Enter name to select : ");
        scanner.nextLine();
        String Sname = scanner.nextLine();
        try(Connection con = jdbc.dataSource().getConnection()){
            String selectByName ="SELECT * FROM employee WHERE name = ?";
            PreparedStatement statement = con.prepareCall(selectByName);
            statement.setString(1,Sname);
            ResultSet resultSet = statement.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender =resultSet.getString("gender");
                String dob = resultSet.getString("dob");
                Integer phone = resultSet.getInt("phone");
                list.add(new Employee(id,name,gender,dob,phone));
            }
            list.stream().forEach(System.out::println);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
