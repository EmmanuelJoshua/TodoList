package com.example.spark.viewpagerdemo;

public class TasksModel {

    private String time_date;
    private String task_details;
    private int taskStatus;
    private int taskColor;

    public int getTaskColor() {
        return taskColor;
    }

    public void setTaskColor(int taskColor) {
        this.taskColor = taskColor;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }

    public String getTask_details() {
        return task_details;
    }

    public void setTask_details(String task_details) {
        this.task_details = task_details;
    }

    public TasksModel(){

    }

    public TasksModel(String time_date, String task_details, int taskStatus, int taskColor){
        this.time_date = time_date;
        this.task_details = task_details;
        this.taskStatus = taskStatus;
        this.taskColor = taskColor;
    }
}
