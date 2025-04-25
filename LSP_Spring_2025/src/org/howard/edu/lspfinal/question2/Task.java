package org.howard.edu.lspfinal.question2;
//Reference used sources:
//https://makoservernet/article/HTML-LSP/
//https://www.w3schools.com/

/**
 * Represents a single task with a unique name, priority, and status.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Creates a new Task.
     *
     * @param name     unique name of the task
     * @param priority integer priority (lower = higher priority)
     * @param status   initial status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the unique name of this task.
     *
     * @return the task’s unique name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns this task’s priority (lower numbers == higher priority).
     *
     * @return the task’s priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the current status of this task.
     *
     * @return the task’s status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates this task’s status.
     *
     * @param status new status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
