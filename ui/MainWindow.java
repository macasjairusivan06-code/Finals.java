package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainWindow extends JFrame {

    private TaskManager manager;
    private JTable table;
    private DefaultTableModel model;
    private TaskForm taskForm;

    public MainWindow(TaskManager manager) {
        this.manager = manager;
        setTitle("To-Do List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addBtn = new JButton("Add Task");
        addBtn.addActionListener(e -> {
            if (taskForm == null || !taskForm.isVisible()) {
                taskForm = new TaskForm(this, manager);
                taskForm.setVisible(true);
            }
        });

        model = new DefaultTableModel(new String[]{
                "Task ID", "Task Name", "Task Description", "Status"
        }, 0);

        table = new JTable(model);

        add(addBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void refreshTable() {
        model.setRowCount(0);
        for (Task t : manager.getTasks()) {
            model.addRow(new Object[]{
                    t.getTaskId(),
                    t.getTaskName(),
                    t.getTaskDescription(),
                    t.getStatus()
            });
        }
    }
}
