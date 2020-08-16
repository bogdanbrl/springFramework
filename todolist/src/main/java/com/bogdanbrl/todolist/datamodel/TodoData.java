package com.bogdanbrl.todolist.datamodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;

public class TodoData {

	private static TodoData todoData = new TodoData();
	private static String filename = "TodoItemsList.txt";
	private static List<TodoItem> todoItemsList;
	private DateTimeFormatter dataFormatter;
	
	public static TodoData getTodoData() {
		return todoData;
	}
	
	private TodoData() {
		dataFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}
	
	public List<TodoItem> getTodoItemsList() {
        return todoItemsList;
    }

	public void setTodoItemsList(List<TodoItem> todoItemsList) {
		this.todoItemsList = todoItemsList;
	}
	
	public void saveItemsOnFile() throws IOException{
		Path path = Paths.get(filename);
		BufferedWriter bw = Files.newBufferedWriter(path);
		try {
			Iterator <TodoItem> iter = todoItemsList.iterator();
			while(iter.hasNext()){
				TodoItem item = iter.next();
				bw.write(String.format("%s\t%s\t%s", 
						item.getActivityDescription(),
						item.getActivityDetails(),
						item.getActivityDeadline().format(dataFormatter)));
				bw.newLine();
			}
		}finally {
			if(bw != null) {
				bw.close();
			}
		}
	}	
		
	public void loadItemsFromFile() throws IOException{
		// convert the list into observable list for observing changes to the list
		todoItemsList = FXCollections.observableArrayList();
		Path path = Paths.get(filename);
		BufferedReader br = Files.newBufferedReader(path);
		
		String item;
		
		try {
			while((item = br.readLine()) != null) {
				String[] itemPieces = item.split("\t");
				String description = itemPieces[0];
				String details = itemPieces[1];
				String deadline = itemPieces[2];
				
				LocalDate date = LocalDate.parse(deadline, dataFormatter);
				TodoItem itemForloading = new TodoItem(description, details, date);
				todoItemsList.add(itemForloading);
			}

		}finally {
			if(br != null) {
				br.close();
			}
		}
	}
	
}

















