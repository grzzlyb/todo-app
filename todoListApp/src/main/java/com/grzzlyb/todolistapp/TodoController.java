package com.grzzlyb.todolistapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/app")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String showTodoList(Model model) {
        List<Todo> theList = todoService.getAllTasks();
        model.addAttribute("todolist", theList);
        return "home";
    }

    @GetMapping("/add")
    public String addTodoList(Model model) {
        model.addAttribute("todo-task", new Todo());
        return "add-form";
    }

    @PostMapping("/save")
    public String saveTodoList(@ModelAttribute("todo-task") Todo theTask) {
        todoService.createTask(theTask);
        return "redirect:/app/list";
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam("taskId") int theId) {
        todoService.deleteTask(theId);
        return "redirect:/app/list";
    }

//    @PostMapping("/update")
//    public String updateTask(Model model) {
//        Todo theTask = todoService.
//        model.addAttribute("theTask", )
//    }
}
