package com.ayoubaitouhmad.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "tasks" , value = "/tasks")
public class TasksController  extends HttpServlet {
    DatabaseConnection dbConnection;

    @Override
    public void init() throws ServletException {
         dbConnection= DatabaseConnection.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("tasks.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         dbConnection = DatabaseConnection.getInstance();

        if (dbConnection.isConnected()) {
            System.out.println("Database is connected.");

            // Retrieve form data
            String title = request.getParameter("taskTitle");
            Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
            Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));



            String sql = "INSERT INTO tasks (title, start_date, end_date, is_task_list) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql);
                stmt.setString(1, title);
                stmt.setString(2, String.valueOf(startDate));
                stmt.setString(3, String.valueOf(endDate));
                stmt.setBoolean(4, true);
                stmt.executeUpdate();



                request.getRequestDispatcher("tasks.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("Failed to connect to the database.");
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to connect to the database.");
        }
    }
}
