package org.howard.edu.lspfinal.question2;
//Reference used sources:
//https://makoservernet/article/HTML-LSP/
//https://www.w3schools.com/

import java.util.*;

/**
 * Manages a collection of Tasks, enforcing unique names
 * and allowing status updates and grouped printing.
 */
public class TaskManager {

    /**
     * Constructs a new TaskManager with an empty task list.
     */
    public TaskManager() {
        // explicit no-arg constructor for Javadoc completeness
    }

    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task.
     *
     * @param name     unique name of the task
     * @param priority integer priority (lower = higher priority)
     * @param status   initial status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name the name of the task to retrieve
     * @return the Task object
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return t;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name   the name of the task to update
     * @param status new status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task t = getTaskByName(name);
        t.setStatus(status);
    }

    /**
     * Prints all tasks grouped by status in the order: TODO, IN_PROGRESS, DONE.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        for (String s : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(s + ":");
            tasks.values().stream()
                .filter(t -> t.getStatus().equals(s))
                .sorted(Comparator.comparingInt(Task::getPriority))
                .forEach(t -> System.out.println("  " + t));
        }
    }
}
