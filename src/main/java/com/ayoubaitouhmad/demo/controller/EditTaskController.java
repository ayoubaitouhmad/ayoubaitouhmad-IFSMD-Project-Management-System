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

@WebServlet("/task/*")
public class EditTaskController extends HttpServlet {
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
//        System.out.println(request.getParameter("id"));
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (taskDAO.getTask(id) != null) {
                SimpleTask task = taskDAO.getTask(id);
                request.setAttribute("task" , task);
                request.getRequestDispatcher("editTask.jsp").forward(request, response);

            }else {
                response.sendRedirect(request.getContextPath() + "/tasks-create");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/tasks-create");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (taskDAO.getTask(id) != null) {
                SimpleTask task = taskDAO.getTask(id);

                String title = request.getParameter("taskTitle");
                Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
                Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));


                task.setTitle(title);
                task.setEndDate(endDate);
                task.setStartDate(startDate);
                taskDAO.updateTask(task);

                System.out.println("updated");

                response.sendRedirect(request.getContextPath() + "/task?id="+task.getId());
            }else {
                response.sendRedirect(request.getContextPath() + "/tasks-create");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/tasks-create");
        }
    }
}

