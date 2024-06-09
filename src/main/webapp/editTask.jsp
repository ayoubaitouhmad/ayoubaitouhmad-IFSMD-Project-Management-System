<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create Task</title>
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
        <h3 class="text-white" >Add Task</h3>
    </div>
</nav>

<div class="container mt-5">
    <h2 class="mt-4">Create Task</h2>
    <form method="post">
        <input type="hidden"  name="id" value="${task.getId()}" required>
        <div class="mb-3">
            <label for="taskTitle" class="form-label">Task Title:</label>
            <input type="text" class="form-control" id="taskTitle" name="taskTitle" value="${task.getTitle()}" required>
        </div>
        <div class="mb-3">
            <label for="startDate" class="form-label">Start Date:</label>
            <input type="date" class="form-control" id="startDate" name="startDate" value="${task.getStartDate()}" required>
        </div>
        <div class="mb-3">
            <label for="endDate" class="form-label">End Date:</label>
            <input type="date" class="form-control" id="endDate" name="endDate" value="${task.getEndDate()}" required>
        </div>

        <button type="submit" class="btn btn-primary">Create Task</button>
    </form>
</div>

<div class="mt-5 p-4 bg-dark text-white text-center">
    <p>Footer</p>
</div>

</body>
</html>
