package model;

public class Task extends AbstractTask {

    private String status;

    public Task(int taskId, String taskName, String taskDescription, String status) {
        super(taskId, taskName, taskDescription);
        setStatus(status);
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        if (status.equals("DONE") || status.equals("ONGOING") || status.equals("NOT STARTED")) {
            this.status = status;
        } else {
            this.status = "NOT STARTED";
        }
    }
}
