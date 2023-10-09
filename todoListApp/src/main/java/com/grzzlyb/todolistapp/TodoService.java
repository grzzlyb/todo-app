package com.grzzlyb.todolistapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
   }

    public List<Todo> getAllTasks() {
        List<Todo> theList = todoRepository.findAll();
        return theList;
    }

    public Todo createTask(Todo theTask) {
        return todoRepository.save(theTask);
    }

    public void deleteTask(int theId) {
       todoRepository.deleteById(theId);
    }

    public Optional<Todo> getTask(int theId) {
        return todoRepository.findById(theId);
    }
}
