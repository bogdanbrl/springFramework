package com.bogdanbrl.todolist.datamodel;

import java.time.LocalDate;

public class TodoItem {

	private String activityDescription;
	private String activityDetails;
	private LocalDate activityDeadline;
	
	
	public TodoItem(String activityDescription, String activityDetails, LocalDate activityDeadline) {
		this.activityDescription = activityDescription;
		this.activityDetails = activityDetails;
		this.activityDeadline = activityDeadline;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public String getActivityDetails() {
		return activityDetails;
	}
	public void setActivityDetails(String activityDetails) {
		this.activityDetails = activityDetails;
	}
	public LocalDate getActivityDeadline() {
		return activityDeadline;
	}
	public void setActivityDeadline(LocalDate activityDeadline) {
		this.activityDeadline = activityDeadline;
	}
	@Override
	public String toString() {
		return activityDescription;
	}
	
	
}




