package model.entities;

import java.time.LocalDateTime;

public class Tarefa {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Priority priority;
    private TaskStatus ts;
    private String notes;

    public Tarefa(String title, String description, LocalDateTime dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public Tarefa(String title, String description, LocalDateTime dueDate, Priority priority, TaskStatus ts) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.ts = ts;
    }

    public Tarefa(String title, String description, LocalDateTime dueDate, Priority priority, TaskStatus ts, String notes) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.ts = ts;
        this.notes = notes;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getTs() {
        return ts;
    }

    public void setTs(TaskStatus ts) {
        this.ts = ts;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Tarefa Title: " + getTitle() + ", Description: " + getDescription() + ",DueDate: "
                + getDueDate() + ", Priority: " + getPriority() + ", TaskStatus: " + getTs();
    }

}
