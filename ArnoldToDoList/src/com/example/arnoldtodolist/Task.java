package com.example.arnoldtodolist;

public class Task {
	//Field To Model Task Object
	private int taskId;
	private boolean priority;
	private String date;
	private String task;
	private boolean isCompleted;
	
	//Constructor
	public Task(){
		
	}
	//Accessors and Modifiers
	public void setTaskId(int id ){
		taskId = id;
	}
	public void setPriority(boolean p){
		priority = p;
	}
	public void setDate(String d){
		date = d;
	}
	public void setTask(String t){
		task = t;
	}
	

}
