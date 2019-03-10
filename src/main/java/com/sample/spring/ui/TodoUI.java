package com.sample.spring.ui;

import com.sample.spring.model.Todo;
import com.sample.spring.service.TodoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


/**
 * Created by bernard-w on 10/3/19.
 */
@Route("todo")
public class TodoUI  extends VerticalLayout {


    @Autowired
    TodoService todoService;



    @PostConstruct
    public void initialize(){
        setLayout();
    }

    public void setLayout(){

       TextField textField=new TextField("Task");
       Button addBtn=new Button("Add");

        Grid<Todo> todoGrid=new Grid<>();

        todoGrid.addColumn(Todo::getTask).setHeader("Task");

       addBtn.addClickListener(buttonClickEvent -> {

           Todo todo=new Todo();
           todo.setTask(textField.getValue());
           todo.setCompleted(0);

           if(todoService.save(todo)!=null){
               Notification.show("Task Added");
               todoGrid.setItems(todoService.findAll());
           }
           else{
               Notification.show("Error Adding Task");
           }

       });

        todoGrid.setItems(todoService.findAll());

        add(textField);
        add(addBtn);
        add(todoGrid);


    }


}
