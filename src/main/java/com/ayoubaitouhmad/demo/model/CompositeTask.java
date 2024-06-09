package com.ayoubaitouhmad.demo.model;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask implements Task {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void display() {
        for (Task task : tasks) {
            task.display();
        }
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public void remove(Task task) {
        tasks.remove(task);
    }

    @Override
    public Task getChild(int index) {
        return tasks.get(index);
    }
}
