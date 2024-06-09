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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/tasks-create")

public class CreateTaskController extends HttpServlet {
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


        System.out.println("Database is connected.");
        request.getRequestDispatcher("createTask.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (dbConnection.isConnected()) {
            System.out.println("Database is connected.");


            String title = request.getParameter("taskTitle");
            Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
            Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));


            Task task = new SimpleTask(title, startDate, endDate);

            taskDAO.addTask((SimpleTask) task);


            response.sendRedirect(request.getContextPath() + "/tasks");

        } else {
            System.out.println("Failed to connect to the database.");
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to connect to the database.");
        }
    }
}
