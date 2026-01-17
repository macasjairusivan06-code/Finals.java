package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import java.awt.*;

public class TaskForm extends JFrame {

    public TaskForm(MainWindow parent, TaskManager manager) {
        setTitle("Add Task");
        setSize(300, 300);
        setLayout(new GridLayout(5, 1));

        int id = manager.generateTaskId();

        JTextField txtId = new JTextField(String.valueOf(id));
        txtId.setEditable(false);

        JTextField txtName = new JTextField();
        JTextArea txtDesc = new JTextArea();

        JComboBox<String> cbStatus = new JComboBox<>(new String[]{
                "NOT STARTED", "ONGOING", "DONE"
        });

        JButton saveBtn = new JButton("Save Task");
        saveBtn.addActionListener(e -> {
            if (txtName.getText().isEmpty() || txtDesc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }

            Task task = new Task(
                    id,
                    txtName.getText(),
                    txtDesc.getText(),
                    cbStatus.getSelectedItem().toString()
            );

            manager.addTask(task);
            parent.refreshTable();
            dispose();
        });

        add(new JLabel("Task ID"));
        add(txtId);
        add(new JLabel("Task Name"));
        add(txtName);
        add(new JLabel("Description"));
        add(new JScrollPane(txtDesc));
        add(cbStatus);
        add(saveBtn);
    }
}
