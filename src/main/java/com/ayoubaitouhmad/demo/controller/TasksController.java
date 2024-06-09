package com.ayoubaitouhmad.demo.controller;


import com.ayoubaitouhmad.demo.DatabaseConnection;
import com.ayoubaitouhmad.demo.dao.SimpleTaskDAO;
import com.ayoubaitouhmad.demo.dao.TaskDAO;
import com.ayoubaitouhmad.demo.model.SimpleTask;
import com.ayoubaitouhmad.demo.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/tasks")

public class TasksController extends HttpServlet {
    DatabaseConnection dbConnection;
    TaskDAO taskDAO;

    @Override
    public void init() throws ServletException {
        dbConnection = DatabaseConnection.getInstance();
        try {
            taskDAO = new SimpleTaskDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("Database is gfdgfd.");
        request.setAttribute("tasks", taskDAO.getAllTasks());
        request.getRequestDispatcher("tasks.jsp").forward(request, response);
    }

}
