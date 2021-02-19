package com.producerapi.producerapidemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskDTO {
    private Long id;

    @NotNull(message = "NotNull.taskDTO.description")
    @Size(min = 1, max = 64, message = "Size.taskDTO.description")
    private String description;

    private boolean completed;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
