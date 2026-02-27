package com.example.tasktracker.controller;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TaskPriority;
import com.example.tasktracker.model.TaskStatus;
import com.example.tasktracker.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Главная страница: таблица + форма (create или edit) + фильтр по priority
    @GetMapping
    public String page(Model model,
                       @RequestParam(value = "editId", required = false) Long editId,
                       @RequestParam(value = "priority", required = false) TaskPriority priority) {

        // список задач (с фильтром или без)
        if (priority != null) {
            model.addAttribute("tasks", service.getByPriority(priority));
        } else {
            model.addAttribute("tasks", service.list());
        }

        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());

        // Если editId есть — открываем форму редактирования
        if (editId != null) {
            model.addAttribute("task", service.get(editId));
            model.addAttribute("editMode", true);
        } else {
            model.addAttribute("task", new Task());
            model.addAttribute("editMode", false);
        }

        return "tasks"; // templates/tasks.html
    }

    // Создать
    @PostMapping
    public String create(@ModelAttribute("task") Task task) {
        service.save(task);
        return "redirect:/tasks";
    }

    // Обновить
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("task") Task formTask) {
        Task existing = service.get(id);

        existing.setTitle(formTask.getTitle());
        existing.setDescription(formTask.getDescription());
        existing.setStatus(formTask.getStatus());
        existing.setPriority(formTask.getPriority());
        existing.setDueDate(formTask.getDueDate());

        service.save(existing);
        return "redirect:/tasks";
    }

    // Удалить
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/tasks";
    }
}