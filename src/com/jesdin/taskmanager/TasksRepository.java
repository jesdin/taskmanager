package com.jesdin.taskmanager;

import com.jesdin.taskmanager.models.Task;

import java.sql.*;
import java.util.ArrayList;

public class TasksRepository {

    public ArrayList<Task> get() {
        try {
            var statement = connection.createStatement();
            String SQL = "SELECT * FROM Task;";
            ResultSet rs = statement.executeQuery(SQL);

            ArrayList<Task> tasks = new ArrayList<>();
            while(rs.next()) {
                Task t = new Task();
                t.setTitle(rs.getString("Title"));
                t.setHighPriority(rs.getBoolean("IsHighPriority"));
                t.setCompleted(rs.getBoolean("IsCompleted"));
                tasks.add(t);
            }
            statement.close();
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Task get(int id) {
        return null;
    }

    public void add(Task task) {

    }

    public void edit(Task task) {

    }

    public void setCompleted(int id) {

    }

    public void setNotCompleted(int id) {

    }

    private Connection connection;

    //  constructor
    public TasksRepository() {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost:1401;databaseName=TaskManagerDB;user=sa;password=admin123";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//            String SQL = "SELECT * FROM Production.Product;";
//            ResultSet rs = stmt.executeQuery(SQL);
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

//    destructor
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(connection != null) {
            if(!connection.isClosed()) {
                connection.close();
            }
            connection = null;
        }

    }
}
