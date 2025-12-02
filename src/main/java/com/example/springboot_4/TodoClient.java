package com.example.springboot_4;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.PostExchange;

// 1. Define the Contract
// This interface describes the API at https://jsonplaceholder.typicode.com/todos
@HttpExchange("/todos")
public interface TodoClient {

    @GetExchange("/{id}")
    Todo getTodo(@PathVariable("id") Integer id);

    // You can easily map other methods like POST, PUT, DELETE
    @PostExchange
    Todo createTodo(@RequestBody Todo todo);
}
