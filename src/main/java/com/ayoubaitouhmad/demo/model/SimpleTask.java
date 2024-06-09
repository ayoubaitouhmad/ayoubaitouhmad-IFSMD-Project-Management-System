package com.ayoubaitouhmad.demo.model;

import java.util.Date;

public class SimpleTask implements Task {
    private int id;
    private String title;
    private Date startDate;
    private Date endDate;

    public SimpleTask() {}

    public SimpleTask(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SimpleTask(int id, String title, Date startDate, Date endDate) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public void display() {
        System.out.println("Simple Task: " + title);
    }

    @Override
    public void add(Task task) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Task task) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
