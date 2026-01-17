package controller;

import java.util.ArrayList;
import model.Task;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int generateTaskId() {
        return tasks.size() + 1;
    }
}
