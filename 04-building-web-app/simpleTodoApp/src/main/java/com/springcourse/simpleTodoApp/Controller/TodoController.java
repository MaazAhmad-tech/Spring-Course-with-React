package com.springcourse.simpleTodoApp.Controller;

import com.springcourse.simpleTodoApp.Entity.Todo;
import com.springcourse.simpleTodoApp.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes(names = "name")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // /list-todos
    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model)
    {
        List<Todo> todos = todoService.findByUsername(todoService.getLoggedInUsername());
        model.addAttribute("todos", todos);
        return "todos";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.GET)
    public String showNewTodo(ModelMap model)
    {
        String username = todoService.getLoggedInUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "todo";
        }
        String username = todoService.getLoggedInUsername();
        todo.setUsername(username);
        todoService.addTodo(todo);
//        todoService.addTodo(username,
//                todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteById(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model)
    {
        Todo todo = todoService.findById(id);
        model.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "todo";
        }
        String username = todoService.getLoggedInUsername();
        todoService.updateTodoByID(id, todo);
        return "redirect:/list-todos";
    }

}
