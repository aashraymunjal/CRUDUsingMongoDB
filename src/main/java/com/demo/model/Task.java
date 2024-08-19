package com.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task_collection")

public class Task {

	@Id
	private String id;
	private String description;
	private int severity;
	private String assignee;
	private int storyPoint;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public int getStoryPoint() {
		return storyPoint;
	}

	public void setStoryPoint(int storyPoint) {
		this.storyPoint = storyPoint;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", severity=" + severity + ", assignee=" + assignee
				+ ", storyPoint=" + storyPoint + "]";
	}

	public Task() {

	}

	public Task(String id, String description, int severity, String assignee, int storyPoint) {
		super();
		this.id = id;
		this.description = description;
		this.severity = severity;
		this.assignee = assignee;
		this.storyPoint = storyPoint;
	}

}
