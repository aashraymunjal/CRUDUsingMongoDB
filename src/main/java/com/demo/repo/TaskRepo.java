package com.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.model.Task;

public interface TaskRepo extends MongoRepository<Task, String> {

	List<Task> findBySeverity(int severity);

	List<Task> findByAssignee(String assignee);

	@Query("{ 'severity': ?0, 'assignee': ?1 }")
	List<Task> findBySeverityAssignee(int severity, String assignee);

}
