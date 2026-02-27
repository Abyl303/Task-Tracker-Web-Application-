package com.example.tasktracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    private LocalDate dueDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Task(String title, String description, TaskStatus status,TaskPriority priority, LocalDate dueDate){
        setTitle(title);
        setDescription(description);
        setStatus(status);
        setPriority(priority);
        setDueDate(dueDate);
    }

    public Task(){}

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public TaskStatus getStatus(){
        return status;
    }
    public TaskPriority getPriority(){
        return priority;
    }
    public LocalDate getDueDate(){
        return  dueDate;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public void setId(Long id) { this.id = id; }

    public void setTitle(String title){
        if(title==null || title.trim().isEmpty()){
            throw new IllegalArgumentException("title can't be empty");
        }
        this.title=title;

    }
    public void setDescription(String description){
        if(description==null || description.trim().isEmpty()){
            throw new IllegalArgumentException("description can't be empty");
        }
        this.description=description;
    }
    public void setStatus(TaskStatus status){
        if(status == null){
            throw new IllegalArgumentException("Status can't be null");
        }
        this.status=status;
    }
    public void setPriority(TaskPriority priority){
        if(priority == null){
            throw new IllegalArgumentException("priority can't be null");
        }
        this.priority=priority;
    }
    public void setDueDate(LocalDate dueDate) {
        if (dueDate != null && dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("dueDate can't be in the past");
        }
        this.dueDate = dueDate;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
