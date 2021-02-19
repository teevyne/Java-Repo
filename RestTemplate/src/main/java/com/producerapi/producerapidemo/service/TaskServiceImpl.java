package com.producerapi.producerapidemo.service;

import com.producerapi.producerapidemo.model.Task;
import com.producerapi.producerapidemo.model.TaskDTO;
import com.producerapi.producerapidemo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl {
    @Autowired
    private TaskRepository repository;

    public List<TaskDTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> new TaskDTO(entity.getId(), entity.getDescription(), entity.isCompleted()))
                .collect(Collectors.toList());
    }

    @Transactional
    public TaskDTO create(TaskDTO task) {
        Task newTask = new Task();
        newTask.setDescription(task.getDescription());
        newTask.setCompleted(task.isCompleted());
        Task savedTask = repository.saveAndFlush(newTask);
        return new TaskDTO(savedTask.getId(), savedTask.getDescription(), savedTask.isCompleted());
    }

    @Transactional
    public TaskDTO update(Long id, TaskDTO task) {
        Task entity = findOneSafe(id);
        entity.setDescription(task.getDescription());
        entity.setCompleted(task.isCompleted());
        return new TaskDTO(entity.getId(), entity.getDescription(), entity.isCompleted());
    }

    @Transactional
    public void delete(Long id) {
        Task task = findOneSafe(id);
        repository.delete(task);
    }

    private Task findOneSafe(Long id) {
        Task task = repository.findById(id).orElse(null);
//        if (task == null) {
//            throw new TaskNotFoundException();
//        } else {
//            return task;
//        }
        return task;
    }
}
