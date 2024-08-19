package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Task;
import com.demo.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService service;

	@PostMapping("/add")
	public Task createTask(@RequestBody Task T) {
		return service.addTask(T);
	}

	@GetMapping("/getAll")
	public List<Task> getTasks() {
		return service.findAllTask();
	}

	@GetMapping("/getById/{id}")
	public Task getTaskById(@PathVariable String id) {
		return service.getTaskById(id);
	}

	@GetMapping("/get/severity/{severity}")
	public List<Task> getTaskBySeverity(@PathVariable int severity) {
		return service.getTaskBySeverity(severity);
	}

	@GetMapping("/get/taskByAssignee/{assignee}")
	public List<Task> getTaskByAssignee(@PathVariable String assignee) {
		return service.getTaskByAssignee(assignee);
	}

	@PutMapping("/update/")
	public Task updateTask(@RequestBody Task t) {
		return service.updateTask(t);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable String id) {
		return service.deleteTask(id);
	}

	@GetMapping("/find/severityAndAssignee/{severity}/{assignee}")
	public List<Task> customFindBySeverityAssignee(@PathVariable int severity, @PathVariable String assignee) {

		return service.findBySeverityAssignee(severity, assignee);

	}

}
