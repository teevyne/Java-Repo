package com.producerapi.producerapidemo.repository;

import com.producerapi.producerapidemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
