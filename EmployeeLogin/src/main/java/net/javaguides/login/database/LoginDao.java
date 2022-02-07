package net.javaguides.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.login.bean.LoginBean;

public class LoginDao {

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "password");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from employee where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }
    
    public boolean resetPasssword(LoginBean loginBean) throws ClassNotFoundException {
        boolean reset = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "password");

            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection
            .prepareStatement("update employee set password = ? where username = ? ")) {
            statement.setString(2, loginBean.getUsername());
            statement.setString(1, loginBean.getPassword());

            System.out.println(statement);
            int  rs = statement.executeUpdate();
            
            if (rs>0) {
            	return reset;
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		return reset;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}