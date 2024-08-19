package com.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Task;
import com.demo.repo.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;

	public Task addTask(Task t) {
		t.setId(UUID.randomUUID().toString().split("-")[0]);
		return repo.save(t);

	}

	public List<Task> findAllTask() {
		return repo.findAll();
	}

	public Task getTaskById(String id) {
		return repo.findById(id).get();
	}

	public List<Task> getTaskBySeverity(int severity) {
		return repo.findBySeverity(severity);
	}

	public List<Task> getTaskByAssignee(String assignee) {
		return repo.findByAssignee(assignee);
	}

	public Task updateTask(Task t) {

		Task found = repo.findById(t.getId()).get();

		found.setDescription(t.getDescription());
		found.setAssignee(t.getAssignee());
		found.setSeverity(t.getSeverity());
		found.setStoryPoint(t.getStoryPoint());

		return repo.save(found);

	}

	public String deleteTask(String taskId) {
		repo.deleteById(taskId);
		return "Task deleted -" + taskId;
	}

	public List<Task> findBySeverityAssignee(int severity, String assignee) {

		return repo.findBySeverityAssignee(severity, assignee);
	}

}
