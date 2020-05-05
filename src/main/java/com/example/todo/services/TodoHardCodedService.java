package com.example.todo.services;

import com.example.todo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todoList = new ArrayList<>();
    private static long id = 0;

    static {
        todoList.add(new Todo(++id, "Rajat", "learn to build angular app", new Date(), false));
        todoList.add(new Todo(++id, "RajatThakur", "learn to build angular with java", new Date(), false));
        todoList.add(new Todo(++id, "Rzzat", "learn to work with both angular and java", new Date(), false));
    }

    public List<Todo> findAll() {
        return todoList;
    }

    public Todo deleteTodo(Long id) {
        Todo todo = findById(id);
        if (todo == null) {
            return null;
        }
        if (todoList.remove(todo)) {
            return todo;
        }
        return todo;

    }

    public Todo findById(long parseLong) {
        for (Todo todo : todoList) {
            if (todo.getId() == parseLong) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            //for insert
            todo.setId(++id);
            todoList.add(todo);
        } else {
            //for update
            deleteTodo(todo.getId());
            todoList.add(todo);
        }
        return todo;
    }
}
