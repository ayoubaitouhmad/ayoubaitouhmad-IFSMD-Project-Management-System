package com.ayoubaitouhmad.demo.model;

public interface Task {
    void display();
    void add(Task task);
    void remove(Task task);
    Task getChild(int index);
}