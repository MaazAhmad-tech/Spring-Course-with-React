package com.springcourse.simpleTodoApp.Service;

import com.springcourse.simpleTodoApp.Entity.Todo;
import com.springcourse.simpleTodoApp.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionAttributes(names = "name")
public class TodoService {

    public TodoRepository todoRepository;
    private static List<Todo> todos = new ArrayList<>();
    public static int todosCount = 0;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    static {
        todos.add(new Todo(++todosCount, "Maaz", "Learn AWS Static", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Maaz", "Learn Dev OPS Static", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "Maaz", "Learn Full Stack DevelopmentStatic", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username)
    {
        return todoRepository.findByUsername(username);
/*        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();*/
    }



    public void addTodo(Todo newTodo)
    {
        todoRepository.save(newTodo);
//        long id = ++todosCount;
//        todos.add(new Todo(++todosCount, username, description, targetDate, done));
    }

    public void deleteById(int id) {

        todoRepository.deleteById(id);
//        Predicate<? super Todo> predicate =
//                todo -> todo.getId() == id;
//        todos.removeIf(predicate);
    }

    public Todo findById(int id) {

        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent())
            return todo.get();
        else return null;
        /*Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;*/
    }

    public void updateTodoByID(int id,@Valid Todo todo) {

        String username = getLoggedInUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
//        Optional<Todo> todoToUpdate = Optional.ofNullable(findById(id));
//        if(todoToUpdate.isPresent())
//        {
//            todoToUpdate.get().setDescription(todo.getDescription());
//            todoToUpdate.get().setTargetDate(todo.getTargetDate());
//        }
    }

    public String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
}
