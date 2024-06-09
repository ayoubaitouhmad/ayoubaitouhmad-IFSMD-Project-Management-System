package com.ayoubaitouhmad.demo.dao;



import com.ayoubaitouhmad.demo.model.SimpleTask;
import com.ayoubaitouhmad.demo.model.Task;

import java.util.List;

public interface TaskDAO {
    void addTask(SimpleTask task);
    void updateTask(SimpleTask task);
    void deleteTask(int id);
    SimpleTask getTask(int id);
    List<SimpleTask> getAllTasks();
}
