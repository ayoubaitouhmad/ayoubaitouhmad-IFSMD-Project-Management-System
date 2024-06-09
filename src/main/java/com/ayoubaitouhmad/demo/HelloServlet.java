package com.ayoubaitouhmad.demo;

import java.io.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet-dd")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");

        DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        System.out.println(dbConnection.isConnected());


//        if (dbConnection.isConnected()) {
//            String sql = "INSERT INTO tasks (title, start_date, end_date, is_task_list) VALUES (?, ?, ?, ?)";
//            try {
//                PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql);
//                stmt.setString(1, "A");
//                stmt.setString(2, "2023-01-01");
//                stmt.setString(3, "2023-01-01");
//                stmt.setBoolean(4, true);
//                stmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }

        // Hello
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}