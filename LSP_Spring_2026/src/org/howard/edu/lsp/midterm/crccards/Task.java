package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a Task with an ID, description, and status.
 * Default status is OPEN.
 * 
 * @author Michael Amo-Arthur
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with the given ID and description.
     * Default status is OPEN.
     * 
     * @param taskId unique identifier for the task
     * @param description description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * 
     * @return task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     * 
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     * 
     * @return task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * Valid values: OPEN, IN_PROGRESS, COMPLETE.
     * Otherwise sets status to UNKNOWN.
     * 
     * @param status new status value
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task.
     * Format: taskId description [status]
     * 
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}