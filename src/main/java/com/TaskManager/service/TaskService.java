package com.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.Task;
import com.TaskManager.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	// Create or Update Task
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	// Get All Tasks
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// Get Task by ID
	public Task getTaskById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.orElse(null);
	}

	// Delete Task by ID
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	//Replace the old task
	public Task replaceTask(Long id, Task taskDetails) {
	    taskRepository.deleteById(id); // Delete old task
	    taskDetails.setId(id); // Assign the same ID to the new task
	    return taskRepository.save(taskDetails); // Save as new entry
	}

}
