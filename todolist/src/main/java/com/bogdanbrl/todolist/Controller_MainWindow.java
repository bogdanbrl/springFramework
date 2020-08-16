package com.bogdanbrl.todolist;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.bogdanbrl.todolist.datamodel.TodoData;
import com.bogdanbrl.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

public class Controller_MainWindow {

	private List<TodoItem> todoItemsList;
	
	@FXML
	private ListView<TodoItem> todoListView;
	@FXML
	private TextArea activityDetailsTextArea;
	@FXML
	private Label activityDeadlineLabel;
	
	
	public void initialize() {
//		todoItemsList = new ArrayList<TodoItem>();
//		
//		TodoItem todoItem1 = new TodoItem("Go to Larisa", "Larisa wants to learn driving", LocalDate.of(2020, Month.AUGUST, 5));
//		TodoItem todoItem2 = new TodoItem("Buy new microwave", "The old one is used by granny. You were assigned to buy a new one from ***** shop", LocalDate.of(2020, Month.AUGUST, 8));
//		TodoItem todoItem3 = new TodoItem("First project", "First project will be done in two days", LocalDate.of(2020, Month.AUGUST, 10));
//		TodoItem todoItem4 = new TodoItem("Modify window mosquito net", "Because  of outside hot temperature, you need to modify mosquito net and mount it on the window", LocalDate.of(2020, Month.AUGUST, 9));
//		TodoItem todoItem5 = new TodoItem("Call parents", "Call parents for details about opened business", LocalDate.of(2020, Month.AUGUST, 21));
//		
//		todoItemsList.add(todoItem1);
//		todoItemsList.add(todoItem2);
//		todoItemsList.add(todoItem3);
//		todoItemsList.add(todoItem4);
//		todoItemsList.add(todoItem5);		
//		
//		TodoData.getTodoData().setTodoItemsList(todoItemsList);
		
		// if first value is selected, changeListener observes that the value of the property has been changed (selected) and shows its details
		todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
			@Override
			public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
				if(newValue!=null) {
					TodoItem item = todoListView.getSelectionModel().getSelectedItem();
					activityDetailsTextArea.setText(item.getActivityDetails());
					activityDeadlineLabel.setText(item.getActivityDeadline().toString());
				}
			}		
		});
			
		todoListView.getItems().setAll(TodoData.getTodoData().getTodoItemsList());
		todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		todoListView.getSelectionModel().selectFirst();
		
		
	}
	
	@FXML
	public void handleClickListView() {
		TodoItem item = todoListView.getSelectionModel().getSelectedItem();
		String details = item.getActivityDetails();
		activityDetailsTextArea.setText(details);
		
		String deadline = item.getActivityDeadline().toString();
		activityDeadlineLabel.setText(deadline);
	}
	
}
