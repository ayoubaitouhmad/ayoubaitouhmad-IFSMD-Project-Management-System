<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ayoubaitouhmad.demo.model.Task" %>
<%@ page import="com.ayoubaitouhmad.demo.model.SimpleTask" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Tasks</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
        .nested-list {
            padding-left: 20px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <h3 class="text-white">Task List</h3>
    </div>
</nav>

<div class="container mt-5">

    <h2 class="mt-4">All Tasks</h2>
    <a href="tasks-create">add task</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Title</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<SimpleTask> tasks = (List<SimpleTask>) request.getAttribute("tasks");
            if (tasks != null) {
                for (SimpleTask task : tasks) {
        %>
        <tr>
            <td><%= task.getTitle() %></td>
            <td><%= task.getStartDate() %></td>
            <td><%= task.getEndDate() %></td>
            <td>
                <a href="task?id=<%= task.getId() %>" class="btn btn-primary btn-sm">Edit</a>
                <a href="task-delete?id=<%= task.getId() %>" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>

<div class="mt-5 p-4 bg-dark text-white text-center">
    <p>Footer</p>
</div>

</body>
</html>
