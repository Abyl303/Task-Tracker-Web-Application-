package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TaskPriority;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> list() {
        return repo.findAll();
    }

    public Task get(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Task not found: " + id));
    }

    public Task save(Task task) {
        return repo.save(task);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public List<Task> getByPriority(TaskPriority priority) {
        return repo.findByPriority(priority);
    }
}