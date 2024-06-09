package com.ayoubaitouhmad.demo.dao;



import com.ayoubaitouhmad.demo.DatabaseConnection;
import com.ayoubaitouhmad.demo.model.SimpleTask;
import com.ayoubaitouhmad.demo.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleTaskDAO implements TaskDAO {
    private Connection connection;

    public SimpleTaskDAO() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }


    @Override
    public void addTask(SimpleTask task) {

        String sql = "INSERT INTO tasks (title, start_date, end_date, is_task_list) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ((SimpleTask) task).getTitle() );
            stmt.setDate(2, new java.sql.Date(task.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(task.getEndDate().getTime()));
            stmt.setBoolean(4, true);
            stmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTask(SimpleTask task) {
        String query = "UPDATE tasks SET title = ?, start_date = ?, end_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, new java.sql.Date(task.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(task.getEndDate().getTime()));
            stmt.setInt(4, task.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(int id) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SimpleTask getTask(int id) {
        SimpleTask task = null;
        String query = "SELECT * FROM tasks WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                task = new SimpleTask(id, title, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<SimpleTask> getAllTasks() {
        List<SimpleTask> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                tasks.add(new SimpleTask(id, title, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
